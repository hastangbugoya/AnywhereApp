package com.example.anywhereapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.anywhereapp.network.MyRetrofit
import com.example.myanywhereapplication.simpsons.model.RelatedTopicSimpsons
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeoutOrNull

class AnywhereViewModel : ViewModel() {
    val dataList = MutableLiveData<List<RelatedTopicSimpsons>?>(listOf())

    fun loadData() {
        viewModelScope.launch(Dispatchers.IO) {
            dataList.postValue(
                withTimeoutOrNull(5000) {
                    withContext(Dispatchers.IO) {
                        MyRetrofit.getService().getSimpsons().body()?.relatedTopicSimpsons
                    }
                }
            )
        }
    }
}