package com.example.kumbarakala.share

import com.example.kumbarakala.data.ArtisanProfile
import com.example.kumbarakala.data.CardLanguage
import com.example.kumbarakala.data.ProductCatalog
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class ShareHelperCaptionTest {

    private val product = ProductCatalog.byId("curd-pot")!!
    private val benefit = product.benefits.first()

    @Test
    fun caption_includes_product_name_and_benefit_headline() {
        val caption = ShareHelper.caption(product, benefit, sampleArtisan())
        assertTrue(caption.contains(product.name))
        assertTrue(caption.contains(benefit.headline))
        assertTrue(caption.contains(benefit.body))
    }

    @Test
    fun caption_includes_artisan_name_and_village_when_set() {
        val caption = ShareHelper.caption(product, benefit, sampleArtisan())
        assertTrue(caption.contains("Rama"))
        assertTrue(caption.contains("Kolar"))
    }

    @Test
    fun caption_includes_phone_when_present() {
        val caption = ShareHelper.caption(product, benefit, sampleArtisan())
        assertTrue(caption.contains("+91 9000000000"))
    }

    @Test
    fun caption_omits_phone_line_when_phone_blank() {
        val caption = ShareHelper.caption(
            product,
            benefit,
            sampleArtisan(phone = "")
        )
        assertFalse(caption.contains("Order direct:"))
    }

    @Test
    fun caption_uses_generic_maker_line_when_artisan_blank() {
        val caption = ShareHelper.caption(product, benefit, ArtisanProfile.Empty)
        assertTrue(caption.contains("Handmade pottery"))
    }

    @Test
    fun caption_contains_brand_hashtag() {
        val caption = ShareHelper.caption(product, benefit, sampleArtisan())
        assertTrue(caption.contains("#KumbaraKala"))
    }

    @Test
    fun caption_in_kannada_uses_kannada_headline_and_body() {
        val caption = ShareHelper.caption(product, benefit, sampleArtisan(), CardLanguage.KANNADA)
        assertTrue(caption.contains(benefit.kannadaHeadline))
        assertTrue(caption.contains(benefit.kannadaBody))
    }

    @Test
    fun caption_defaults_to_english() {
        val caption = ShareHelper.caption(product, benefit, sampleArtisan())
        assertTrue(caption.contains(benefit.headline))
        assertFalse(caption.contains(benefit.kannadaHeadline))
    }

    private fun sampleArtisan(
        name: String = "Rama",
        village: String = "Kolar",
        phone: String = "+91 9000000000"
    ) = ArtisanProfile(
        name = name,
        village = village,
        phone = phone,
        heritageYears = "60",
        bio = ""
    )
}
