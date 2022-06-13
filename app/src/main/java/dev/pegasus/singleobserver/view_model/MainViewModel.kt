package dev.pegasus.singleobserver.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import dev.pegasus.singleobserver.view_model.observer.SingleLiveEvent

class MainViewModel : ViewModel() {

    private var number = 0

    private val resultMutableLiveData = SingleLiveEvent<Int>()
    val resultLiveData: LiveData<Int> get() = resultMutableLiveData

    fun add() {
        number++
        resultMutableLiveData.value = number
    }
}