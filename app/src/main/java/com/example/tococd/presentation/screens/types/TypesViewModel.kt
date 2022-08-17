package com.example.tococd.presentation.screens.types

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tococd.di.IoDispatcher
import com.example.tococd.domain.model.TypesModel
import com.example.tococd.domain.model.TypesProvider
import com.example.tococd.domain.repository.DataStoreOperations
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TypesViewModel @Inject constructor(
    private val dataStoreOperations: DataStoreOperations,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) : ViewModel() {
    private val _typesList:MutableStateFlow<TypesUiState> = MutableStateFlow(TypesUiState())
    val typesList: StateFlow<TypesUiState> = _typesList.asStateFlow()

    val typesDisplayedFirstTime = dataStoreOperations.getTypes()

    private fun getAllTypesList() {
        val list = TypesProvider.getAll()
        _typesList.update { state -> state.copy(types = list) }
    }

    fun saveDisplayedFirstTime() {
        viewModelScope.launch(dispatcher) {
            dataStoreOperations.saveTypes(true)
        }
    }

    init {
        getAllTypesList()
    }

    data class TypesUiState(
        val types: List<TypesModel> = emptyList()
    )
}