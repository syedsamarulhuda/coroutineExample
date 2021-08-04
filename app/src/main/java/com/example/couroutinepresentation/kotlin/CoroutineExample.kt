package com.example.couroutinepresentation.kotlin

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.runBlocking

fun main() =
    runBlocking {
        joinAll(
            async { coroutineOne() },
            async { coroutineTwo() }
        )
    }

suspend fun coroutineOne() {
    println("Coroutine one is started")
    delay(2000)
    println("Coroutine one is complete")
}

suspend fun coroutineTwo() {
    println("Coroutine two is started")
    delay(3000)
    println("Coroutine two is complete")
}
