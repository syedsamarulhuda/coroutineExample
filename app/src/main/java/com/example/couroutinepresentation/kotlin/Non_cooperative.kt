package com.example.couroutinepresentation.kotlin

fun main() {
    routineOne()
    routineTwo()
}

fun routineOne() {
    println("Routine one is started")
    Thread.sleep(3000)
    println("Routine one is complete")
}

fun routineTwo() {
    println("Routine two is started")
    Thread.sleep(2000)
    println("Routine two is complete")
}