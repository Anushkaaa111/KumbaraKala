package com.example.kumbarakala.nav

object Destinations {
    const val ONBOARDING = "onboarding"
    const val HOME = "home"
    const val PROFILE = "profile"
    const val ABOUT = "about"
    const val DETAIL = "detail/{productId}"
    const val CARD = "card/{productId}/{benefitIndex}"

    fun detail(productId: String) = "detail/$productId"
    fun card(productId: String, benefitIndex: Int) = "card/$productId/$benefitIndex"
}
