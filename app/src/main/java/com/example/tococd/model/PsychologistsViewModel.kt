package com.example.tococd.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tococd.service.PsychologistsResponse
import com.example.tococd.view.fragment.PsychologistsFragment

class PsychologistsViewModel: ViewModel() {
    val psychologistsList = MutableLiveData<List<PsychologistsResponse>>()

//    fun getAllPsychologistsList(){
//        val list = PsychologistsFragment.AllPsychologists()
//        psychologistsList.postValue(list)
//    }
}