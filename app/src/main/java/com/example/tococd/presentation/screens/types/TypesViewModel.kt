package com.example.tococd.presentation.screens.types

import androidx.lifecycle.ViewModel
import com.example.tococd.domain.model.TypesModel
import com.example.tococd.domain.model.TypesProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class TypesViewModel : ViewModel() {
    private val _typesList:MutableStateFlow<TypesUiState> = MutableStateFlow(TypesUiState())
    val typesList: StateFlow<TypesUiState> = _typesList.asStateFlow()

    private fun getAllTypesList() {
        val list = TypesProvider.getAll()
        _typesList.update { state -> state.copy(types = list) }
    }

    init {
        getAllTypesList()
    }

    data class TypesUiState(
        val types: List<TypesModel> = emptyList()
    )
}