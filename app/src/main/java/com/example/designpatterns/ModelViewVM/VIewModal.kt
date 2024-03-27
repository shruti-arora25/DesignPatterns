package com.example.designpatterns.ModelViewVM

import androidx.lifecycle.ViewModel

class VIewModal:ViewModel() {


    //Exposes Calculate method to view interact with the data
    fun calculate(num1:Int,num2:Int):Modal{

        val sum=num1+num2
        return Modal(num1,num2,sum)
    }


}