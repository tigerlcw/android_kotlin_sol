package com.example.quest4

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {

    class MyViewModel : ViewModel(){
        val count: MutableLiveData<Int> = MutableLiveData<Int>()


    fun increaseCount() {
        count.value = (count.value ?: 0) + 1
    }

    fun dereaseCount() {
        count.value = (count.value ?: 0) - 1
    }


    }
}