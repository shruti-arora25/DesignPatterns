package com.example.designpatterns.mvc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.designpatterns.R
import com.example.designpatterns.databinding.ActivityViewBinding

class view : AppCompatActivity() {

    private lateinit var bind: ActivityViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind=DataBindingUtil.setContentView(this, R.layout.activity_view)

        var modalC: modal = getData()
        var viewC = view()

        var Control = Controller(modalC, viewC)

        bind.btn.setOnClickListener {
            Control.setName("ABC")
            Control.setRoll("00")
            Control.updateView()
        }
    }

    private fun getData(): modal {
        return modal("XYZ", "12")
    }

    fun printDetails(studentName: String, studentRoll: String) {

        Log.d("TAG------->", studentName)

    //      bind.name.text = studentName
//       bind.no.text=studentRoll


    }
}