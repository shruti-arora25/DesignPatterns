package com.example.designpatterns.Coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.designpatterns.databinding.ActivityBasicBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlinx.coroutines.yield
import kotlin.system.measureTimeMillis

class Basic : AppCompatActivity() {

    private lateinit var bind: ActivityBasicBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityBasicBinding.inflate(layoutInflater)
        setContentView(bind.root)

//        GlobalScope.launch {
////            Log.d("GLobal0-------->", "GLobal")
////            delay(1000)
////            Log.d("GLobal0.1-------->", "GLobal")
//                // infinite loop
//                while (true) {
//                    delay(1000)
//                    Log.d("1--------->", "Still Running..")
//                }
//        }

        GlobalScope.launch {
            val time = measureTimeMillis {
                val ans1 = doCall1()
                val ans2 = doCall2()

                val job1 = launch {
                    Log.d("ANS1----------->", ans1)
                }
                val job2 = launch {
                    Log.d("ANS2---------->", ans2)
                }

//                val job1=async {doCall1()}
//                val job2=async {doCall2()}
//
//                Log.d("By Await--------------->", job1.await())
//                Log.d("By Await--------------->", job2.await())

                job1.join()
                job2.join()

            }

            Log.d("GLobal1-------->", time.toString())
        }

    }


//    runBlocking{
//        launch {
//            delay(8000)
//           // job.cancel()
//            Log.d("GLobal2-------->", "GLobal")
//        }
//    }


}


private suspend fun doCall1(): String {

    delay(2000)
    return "This is n/w calling1"
}

private suspend fun doCall2(): String {

    delay(2000)
    return "This is n/w calling2"
}



