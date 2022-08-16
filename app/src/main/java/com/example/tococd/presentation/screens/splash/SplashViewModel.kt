package com.example.tococd.presentation.screens.splash

import androidx.lifecycle.ViewModel
import com.example.tococd.domain.repository.DataStoreOperations
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val dataStoreOperations: DataStoreOperations
): ViewModel() {
    val onboardinDisplayed = dataStoreOperations.getOnboardingDisplayed()
}