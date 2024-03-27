package com.example.designpatterns.ModelViewVM

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.designpatterns.R
import com.example.designpatterns.databinding.ActivityUiBinding

class UI : AppCompatActivity() {

    private lateinit var bind:ActivityUiBinding
    private lateinit var ViewModalObj: VIewModal

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = DataBindingUtil.setContentView(this,R.layout.activity_ui)

        ViewModalObj = ViewModelProvider(this)[VIewModal::class.java]

        bind.result.setOnClickListener {
            val number1 = bind.num1.toString().toIntOrNull() ?: 0
            val number2 = bind.num2.toString().toIntOrNull() ?: 0

            val result = ViewModalObj.calculate(number1, number2)
            bind.result.text = "${result.sum}"

        }
    }
}

