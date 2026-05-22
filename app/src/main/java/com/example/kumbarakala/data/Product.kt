package com.example.kumbarakala.data

enum class Category(val display: String) {
    KITCHEN("Kitchen"),
    DRINKWARE("Drinkware"),
    COOKWARE("Cookware"),
    LAMPS("Lamps"),
    DECOR("Decor"),
    GARDEN("Garden"),
    STORAGE("Storage")
}

enum class CardLanguage(val short: String, val display: String) {
    ENGLISH("EN", "English"),
    KANNADA("ಕನ", "ಕನ್ನಡ")
}

data class BenefitTemplate(
    val headline: String,
    val body: String,
    val tagline: String,
    val kannadaHeadline: String,
    val kannadaBody: String,
    val kannadaTagline: String
) {
    fun headlineFor(lang: CardLanguage): String =
        if (lang == CardLanguage.KANNADA) kannadaHeadline else headline

    fun bodyFor(lang: CardLanguage): String =
        if (lang == CardLanguage.KANNADA) kannadaBody else body

    fun taglineFor(lang: CardLanguage): String =
        if (lang == CardLanguage.KANNADA) kannadaTagline else tagline
}

data class Product(
    val id: String,
    val name: String,
    val category: Category,
    val tagline: String,
    val imageUrl: String,
    val originStory: String,
    val benefits: List<BenefitTemplate>,
    val imageResId: Int? = null
) {
    val imageModel: Any get() = imageResId ?: imageUrl
}
