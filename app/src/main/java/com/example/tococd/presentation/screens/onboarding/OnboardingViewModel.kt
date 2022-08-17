package com.example.tococd.presentation.screens.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tococd.di.IoDispatcher
import com.example.tococd.domain.repository.DataStoreOperations
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    private val dataStoreOperations: DataStoreOperations,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
): ViewModel() {
    fun saveOnboardingDisplayed() {
        viewModelScope.launch(dispatcher) {
            dataStoreOperations.setOnboardingDisplayed(true)
        }
    }
}