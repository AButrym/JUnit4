package com.softserve.edu

import android.util.Log

class Game {
    var score = 0
        private set
    var highScore = 0
        private set

    fun incrementScore() {
//        Log.d("mylog", "score = $score  highScore = $highScore")
        score++
        if (score > highScore) {
            highScore++
        }
    }
}