package com.example.tococd.presentation.screens.psychologist.state

import com.example.tococd.domain.model.Psychologist

data class PsychologistUiState(
    val data: List<Psychologist>? = null,
    val hasError: Boolean = false
)

sealed class Effect {
    data class IsLoading(val loading: Boolean): Effect()
    data class ShowSnackBar(val message: String): Effect()
}