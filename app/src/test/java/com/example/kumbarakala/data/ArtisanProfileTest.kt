package com.example.kumbarakala.data

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class ArtisanProfileTest {

    @Test
    fun empty_profile_is_not_complete() {
        assertFalse(ArtisanProfile.Empty.isComplete)
    }

    @Test
    fun profile_missing_phone_is_not_complete() {
        val p = ArtisanProfile(name = "Rama", village = "Kolar", phone = "", heritageYears = "", bio = "")
        assertFalse(p.isComplete)
    }

    @Test
    fun profile_missing_village_is_not_complete() {
        val p = ArtisanProfile(name = "Rama", village = "", phone = "+91 9000000000", heritageYears = "", bio = "")
        assertFalse(p.isComplete)
    }

    @Test
    fun profile_with_required_fields_is_complete() {
        val p = ArtisanProfile(
            name = "Rama",
            village = "Kolar",
            phone = "+91 9000000000",
            heritageYears = "60",
            bio = "Third-generation potter"
        )
        assertTrue(p.isComplete)
    }

    @Test
    fun blank_fields_are_treated_as_missing() {
        val p = ArtisanProfile(name = "   ", village = "Kolar", phone = "+91 9", heritageYears = "", bio = "")
        assertFalse(p.isComplete)
    }

    @Test
    fun empty_singleton_has_all_blank_strings() {
        val e = ArtisanProfile.Empty
        assertEquals("", e.name)
        assertEquals("", e.village)
        assertEquals("", e.phone)
        assertEquals("", e.heritageYears)
        assertEquals("", e.bio)
    }
}
