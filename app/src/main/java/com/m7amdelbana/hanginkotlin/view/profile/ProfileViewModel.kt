package com.m7amdelbana.hanginkotlin.view.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileViewModel : ViewModel() {

    var name = MutableLiveData<String>()
    var status = MutableLiveData<String>()
    var email = MutableLiveData<String>()
    var phone = MutableLiveData<String>()
    var city = MutableLiveData<String>()

    init {
        name.value = "Mohamed Elbana"
        status.value = "Hey there, I'm using the app now!"
    }

    fun onEdit() {

    }

}
