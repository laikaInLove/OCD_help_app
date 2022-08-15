package com.example.tococd.presentation.screens.information

import androidx.lifecycle.ViewModel
import com.example.tococd.model.InformationModel
import com.example.tococd.model.InformationProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class InformationViewModel : ViewModel() {

    private val _informationList: MutableStateFlow<List<InformationModel>> =
        MutableStateFlow(InformationProvider.informationList)
    val informationList: StateFlow<List<InformationModel>> = _informationList.asStateFlow()
}