package com.example.kumbarakala.data

data class ArtisanProfile(
    val name: String,
    val village: String,
    val phone: String,
    val heritageYears: String,
    val bio: String
) {
    val isComplete: Boolean
        get() = name.isNotBlank() && village.isNotBlank() && phone.isNotBlank()

    companion object {
        val Empty = ArtisanProfile(
            name = "",
            village = "",
            phone = "",
            heritageYears = "",
            bio = ""
        )
    }
}
