package com.example.tococd.presentation.screens.information

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tococd.di.IoDispatcher
import com.example.tococd.domain.repository.DataStoreOperations
import com.example.tococd.domain.model.InformationModel
import com.example.tococd.domain.model.InformationProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InformationViewModel @Inject constructor(
    private val dataStoreOperations: DataStoreOperations,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _informationList: MutableStateFlow<List<InformationModel>> =
        MutableStateFlow(InformationProvider.informationList)
    val informationList: StateFlow<List<InformationModel>> = _informationList.asStateFlow()

    fun saveDisplayedFirstTime() {
        viewModelScope.launch(dispatcher) {
            dataStoreOperations.saveInformation(true)
        }
    }

    val informationDisplayedFirstTime = dataStoreOperations.getInformation()
    val userName = dataStoreOperations.getName()
}