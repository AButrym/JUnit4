package com.softserve.edu.service

class CalcFilter(val calc: Calc) {
    constructor() : this(Calc())

    fun add(arg0: String, arg1: String): String {
        return calc.add(arg0.toDouble(), arg1.toDouble()).toString()
    }
}
