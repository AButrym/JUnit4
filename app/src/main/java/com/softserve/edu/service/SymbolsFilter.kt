package com.softserve.edu.service

fun DigitalFilter(text: String): String {
    val regex = Regex("\\D+")
    return regex.replace(text, "")
}
