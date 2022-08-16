package com.example.tococd.domain.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tococd.data.remote.response.PsychologistsResponse

class PsychologistsViewModel: ViewModel() {
    val psychologistsList = MutableLiveData<List<PsychologistsResponse>>()

//    fun getAllPsychologistsList(){
//        val list = PsychologistsFragment.AllPsychologists()
//        psychologistsList.postValue(list)
//    }
}