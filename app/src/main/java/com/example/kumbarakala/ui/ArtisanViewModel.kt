package com.example.kumbarakala.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.kumbarakala.data.ArtisanProfile
import com.example.kumbarakala.data.ArtisanProfileRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ArtisanViewModel(app: Application) : AndroidViewModel(app) {

    private val repo = ArtisanProfileRepository(app)

    val profile: StateFlow<ArtisanProfile> = repo.profile.stateIn(
        viewModelScope,
        SharingStarted.Eagerly,
        ArtisanProfile.Empty
    )

    fun save(profile: ArtisanProfile) {
        viewModelScope.launch { repo.save(profile) }
    }
}
