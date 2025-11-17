package com.softserve.edu

fun shouldIncrementHighScore_whenIncrementingScore() {
    val game = Game()
    game.incrementScore()
    if (game.highScore == 1) {
        print("Success")
    } else {
        throw AssertionError("Score and HighScore don't match")
    }
}
