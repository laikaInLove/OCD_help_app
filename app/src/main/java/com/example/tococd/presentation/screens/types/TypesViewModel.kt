package com.example.tococd.presentation.screens.types

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tococd.model.TypesModel
import com.example.tococd.model.TypesProvider
import com.example.tococd.utils.Event

class TypesViewModel : ViewModel() {

    private val _typesList = MutableLiveData<Event<List<TypesModel>>>()
    val typesList: LiveData<Event<List<TypesModel>>> = _typesList

    fun getAllTypesList() {
        val list = TypesProvider.getAll()
        _typesList.postValue(Event(list))
    }

}