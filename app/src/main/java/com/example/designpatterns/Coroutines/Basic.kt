package com.example.designpatterns.Coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.designpatterns.databinding.ActivityBasicBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlinx.coroutines.yield

class Basic : AppCompatActivity() {

    private lateinit var bind: ActivityBasicBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityBasicBinding.inflate(layoutInflater)
        setContentView(bind.root)


       //  doCall()         can't call a suspend method
      //  gives an error as that is coroutine method , should call inside launch method

        runBlocking {
            Log.d("runblocking", doCall())
        }


        Log.d("MAinThread--------------->>", Thread.currentThread().name)


        GlobalScope.launch(Dispatchers.IO) {
            Log.d("FirstG------------->", Thread.currentThread().name)
            val call = doCall()
            yield()
            Log.d("suspend fun", call)



            CoroutineScope(Dispatchers.Main).launch {
                Log.d("SecondG--------------->>", Thread.currentThread().name)
                bind.text.setText("Call")

            }


            GlobalScope.launch {
                Log.d("Scope/------->", "LAunch")
            }

            withContext(Dispatchers.Main) {
                //Name of thread-main
                Log.d("THirdContext--------------->>", Thread.currentThread().name)

                Log.d("Third--------------->>", call)
                bind.text.setText(call)
            }

            withContext(Dispatchers.Main) {
                //Name of thread-main
                Log.d("lastContext--------------->>", Thread.currentThread().name)

            }


            CoroutineScope(Dispatchers.Main).launch {
                Log.d("FourthCoroutine-------------->>", Thread.currentThread().name)

            }

        }


//runBlocking {
//    GlobalScope.launch {
//        Log.d("GLobal1-------->", "GLobal")
//    }
//
//    CoroutineScope(Dispatchers.Main).launch {
//        Log.d("Scope-------->", "Coroutine Scope")
//    }
//}
//
//
//    GlobalScope.launch {
//        delay(1000)
//        Log.d("GLobal2-------->", "GLobal")
//    }

        Log.d("mainThread--------------->>", Thread.currentThread().name)
        }


    private suspend fun doCall(): String {

        delay(1000)
        return "This is n/w calling"
    }
}