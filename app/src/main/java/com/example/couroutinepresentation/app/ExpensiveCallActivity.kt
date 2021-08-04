package com.example.couroutinepresentation.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.couroutinepresentation.R
import kotlinx.android.synthetic.main.activity_expensive_call.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.math.BigInteger
import java.util.*
import kotlin.system.measureTimeMillis

private const val TAG = "MY_TAG"
class ExpensiveCallActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expensive_call)

        btnCompute.setOnClickListener {
            progressBar.visibility = View.VISIBLE
            CoroutineScope(Dispatchers.Default).launch {
                val timeTaken = doExpensiveWork()
                withContext(Dispatchers.Main) {
                    progressBar.visibility = View.INVISIBLE
                    textView.text = timeTaken
                }
            }
        }
    }

    private suspend fun doExpensiveWork() = withContext(Dispatchers.Default) {
        Log.i(TAG, "doExpensiveWork coroutine thread: ${Thread.currentThread().name}")
        val timeTakenMillis = measureTimeMillis { BigInteger.probablePrime(2200, Random()) }
        "Time taken (s): ${timeTakenMillis/1000}"
    }
}