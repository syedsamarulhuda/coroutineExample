package com.example.couroutinepresentation.kotlin

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main()= runBlocking{

    println("Thread name = ${Thread.currentThread().name}")

    val duration = measureTimeMillis {
            repeat(1_000_000) {
                launch {
                    delay(3000)
                    print(".")
                }
            }
    }

  println("Time = ${duration/1000} seconds")

}