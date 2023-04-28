package com.example.anywhereapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.anywhereapp.network.MyRetrofit
import com.example.myanywhereapplication.simpsons.model.RelatedTopic
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeoutOrNull

class AnywhereViewModel : ViewModel() {
    val dataList = MutableLiveData<List<RelatedTopic>?>(listOf())

    fun loadData() {
        viewModelScope.launch(Dispatchers.IO) {
            dataList.postValue(
                withTimeoutOrNull(5000) {
                    async {
                        MyRetrofit.getService().getCharacters().body()?.relatedTopicSimpsons
                    }.await()
                }
            )
        }
    }

    fun filterList(filter: String): List<RelatedTopic> {
        return dataList.value?.filter {
            it.text?.contains(filter, true) ?: false
        } ?: listOf()
    }
}