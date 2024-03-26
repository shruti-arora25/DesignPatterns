package com.example.designpatterns

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.designpatterns.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var num = 0
    private lateinit var vm: ViewModelDemo

    private lateinit var bind: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        vm = ViewModelProvider(this)[ViewModelDemo::class.java]

        bind.text.text = vm.number.toString()

        bind.btn.setOnClickListener {
            add()
        }

    }


    private fun add() {
//        num++
//        bind.text.setText(num.toString())

        vm.addNum()
        bind.text.text = vm.number.toString()


    }
}

