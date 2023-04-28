package com.example.anywhereapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.anywhereapp.network.MyRetrofit
import com.example.myanywhereapplication.simpsons.model.RelatedTopic
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeoutOrNull

class AnywhereViewModel : ViewModel() {
    val dataList = MutableLiveData<List<RelatedTopic>?>(listOf())
    var filteredList = listOf<RelatedTopic>()
    fun loadData() {
        viewModelScope.launch(Dispatchers.IO) {
            dataList.postValue(
                withTimeoutOrNull(5000) {
                    withContext(Dispatchers.IO) {
                        MyRetrofit.getService().getCharacters().body()?.relatedTopicSimpsons
                    }
                }
            )
        }
    }

    fun filterList(filter: String): List<RelatedTopic> {
        filteredList = dataList.value?.filter {
            it.text?.contains(filter, true) ?: false
        } ?: listOf()
        return filteredList
    }
}