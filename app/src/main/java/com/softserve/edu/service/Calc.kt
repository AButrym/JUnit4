package com.softserve.edu.service

class Calc(private val arg1: Double = 0.0) {
    constructor(arg1: String) : this(arg1.toDouble())

    fun add(arg0: Double): Double {
        return arg0 + arg1;
    }

    fun add(arg0: Double, arg1: Double): Double {
        return arg0 + arg1;
    }

    fun sub(arg0: Double, arg1: Double): Double {
        return arg0 - arg1;
    }
}
