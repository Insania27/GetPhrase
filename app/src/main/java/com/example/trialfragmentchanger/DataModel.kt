package com.example.trialfragmentchanger

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DataModel : ViewModel() {

    var nameOfUser: MutableLiveData<String> = MutableLiveData()

    var surnameOfUser: MutableLiveData<String> = MutableLiveData()


}