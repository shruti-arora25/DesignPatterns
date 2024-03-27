package com.example.designpatterns.mvvm

import androidx.lifecycle.ViewModel

class ViewModelDemo:ViewModel() {


    var number=0
    fun addNum(){
        number++
    }


}