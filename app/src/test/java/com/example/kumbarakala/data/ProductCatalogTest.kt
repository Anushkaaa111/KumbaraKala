package com.example.kumbarakala.data

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class ProductCatalogTest {

    @Test
    fun catalog_has_exactly_twelve_products() {
        assertEquals(12, ProductCatalog.products.size)
    }

    @Test
    fun all_product_ids_are_unique() {
        val ids = ProductCatalog.products.map { it.id }
        assertEquals(ids.size, ids.toSet().size)
    }

    @Test
    fun every_product_has_image_url() {
        ProductCatalog.products.forEach { product ->
            assertTrue(
                "Product ${product.id} has blank image URL",
                product.imageUrl.isNotBlank()
            )
            assertTrue(
                "Product ${product.id} should use https",
                product.imageUrl.startsWith("https://")
            )
        }
    }

    @Test
    fun every_product_has_name_tagline_and_origin() {
        ProductCatalog.products.forEach { product ->
            assertTrue(product.name.isNotBlank())
            assertTrue(product.tagline.isNotBlank())
            assertTrue(product.originStory.isNotBlank())
        }
    }

    @Test
    fun every_product_has_at_least_three_benefit_variants() {
        ProductCatalog.products.forEach { product ->
            assertTrue(
                "Product ${product.id} has fewer than 3 benefits",
                product.benefits.size >= 3
            )
        }
    }

    @Test
    fun every_benefit_has_headline_body_and_tagline() {
        ProductCatalog.products.flatMap { it.benefits }.forEach { benefit ->
            assertTrue(benefit.headline.isNotBlank())
            assertTrue(benefit.body.isNotBlank())
            assertTrue(benefit.tagline.isNotBlank())
        }
    }

    @Test
    fun byId_returns_matching_product() {
        val product = ProductCatalog.byId("curd-pot")
        assertNotNull(product)
        assertEquals("Curd Pot", product!!.name)
    }

    @Test
    fun all_product_names_are_in_english_ascii() {
        ProductCatalog.products.forEach { product ->
            assertTrue(
                "Product name should be plain English: ${product.name}",
                product.name.all { it.code < 128 }
            )
        }
    }

    @Test
    fun every_benefit_has_kannada_translations() {
        ProductCatalog.products.flatMap { it.benefits }.forEach { benefit ->
            assertTrue(benefit.kannadaHeadline.isNotBlank())
            assertTrue(benefit.kannadaBody.isNotBlank())
            assertTrue(benefit.kannadaTagline.isNotBlank())
        }
    }

    @Test
    fun kannada_translations_use_kannada_script() {
        // Kannada Unicode block: U+0C80..U+0CFF
        val kannadaRange = 0x0C80..0x0CFF
        ProductCatalog.products.flatMap { it.benefits }.forEach { benefit ->
            val hasKannada = benefit.kannadaHeadline.any { it.code in kannadaRange } ||
                benefit.kannadaBody.any { it.code in kannadaRange }
            assertTrue(
                "Kannada fields should contain at least one Kannada code point",
                hasKannada
            )
        }
    }

    @Test
    fun byId_returns_null_for_unknown_id() {
        assertNull(ProductCatalog.byId("not-a-real-id"))
    }

    @Test
    fun category_distribution_covers_multiple_categories() {
        val categories = ProductCatalog.products.map { it.category }.toSet()
        assertTrue(
            "Catalog should span at least 4 categories, got $categories",
            categories.size >= 4
        )
    }

    @Test
    fun benefits_are_unique_within_a_product() {
        ProductCatalog.products.forEach { product ->
            val headlines = product.benefits.map { it.headline }
            assertEquals(
                "Product ${product.id} has duplicate benefit headlines",
                headlines.size,
                headlines.toSet().size
            )
        }
    }

    @Test
    fun every_image_url_points_to_unsplash() {
        ProductCatalog.products.forEach { product ->
            assertTrue(
                "Product ${product.id} not from Unsplash CDN",
                product.imageUrl.contains("images.unsplash.com")
            )
        }
    }

    @Test
    fun unsplash_query_params_present_for_consistent_sizing() {
        ProductCatalog.products.forEach { product ->
            assertTrue(
                "Product ${product.id} missing width/fit params",
                product.imageUrl.contains("w=") && product.imageUrl.contains("fit=")
            )
        }
    }

    @Test
    fun no_two_products_share_the_same_image() {
        val urls = ProductCatalog.products.map { it.imageUrl }
        assertEquals(
            "Different products should not share photographs",
            urls.size,
            urls.toSet().size
        )
    }

    @Test
    fun categories_display_strings_are_non_blank() {
        Category.entries.forEach { category ->
            assertFalse(category.display.isBlank())
        }
    }
}
