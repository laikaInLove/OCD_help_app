package com.example.tococd.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tococd.model.InformationModel
import com.example.tococd.model.InformationProvider
import kotlinx.coroutines.launch

class InformationViewModel : ViewModel() {

    init {
        getAllInformationList() // No se llama
    }

    //Internal MutableLiveData
    private val _informationList = MutableLiveData<List<InformationModel>>()

    //External LiveData
    val informationList: LiveData<List<InformationModel>> = _informationList

     private fun getAllInformationList() {
         viewModelScope.launch {
             try {
                 val list = InformationProvider.getAll()
                 _informationList.value = list
             } catch (e: Exception) {
                print(e)
             }
         }
    }

}