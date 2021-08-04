package com.example.couroutinepresentation.kotlin

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread
import kotlin.system.measureTimeMillis

fun main(){
    create100kThreads()
    //create100kCoroutines()
}

fun create100kCoroutines() = runBlocking{

    val duration = measureTimeMillis {
        repeat(100_000){
            launch {
                delay(1000)
                print(".")
            }
        }
    }
    println("Time = ${duration/1000} seconds")
}

fun create100kThreads(){

    val duration = measureTimeMillis {
        repeat(10_000){
            thread {
                Thread.sleep(1000)
                print(".")
            }
        }
    }
    println("Time = ${duration/1000} seconds")
}