package com.example.kumbarakala.data

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.profileStore by preferencesDataStore(name = "artisan_profile")

class ArtisanProfileRepository(private val context: Context) {

    private object Keys {
        val NAME = stringPreferencesKey("name")
        val VILLAGE = stringPreferencesKey("village")
        val PHONE = stringPreferencesKey("phone")
        val HERITAGE = stringPreferencesKey("heritage_years")
        val BIO = stringPreferencesKey("bio")
    }

    val profile: Flow<ArtisanProfile> = context.profileStore.data.map { prefs ->
        ArtisanProfile(
            name = prefs[Keys.NAME].orEmpty(),
            village = prefs[Keys.VILLAGE].orEmpty(),
            phone = prefs[Keys.PHONE].orEmpty(),
            heritageYears = prefs[Keys.HERITAGE].orEmpty(),
            bio = prefs[Keys.BIO].orEmpty()
        )
    }

    suspend fun save(profile: ArtisanProfile) {
        context.profileStore.edit { prefs ->
            prefs[Keys.NAME] = profile.name.trim()
            prefs[Keys.VILLAGE] = profile.village.trim()
            prefs[Keys.PHONE] = profile.phone.trim()
            prefs[Keys.HERITAGE] = profile.heritageYears.trim()
            prefs[Keys.BIO] = profile.bio.trim()
        }
    }
}
