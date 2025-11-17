package com.softserve.edu

import io.mockk.bdd.given
import io.mockk.bdd.then
import io.mockk.every
import io.mockk.mockkClass
import io.mockk.verify
import org.junit.Assert
import org.junit.Test

class GameUnitTest {
    @Test
    fun whenIncrementingScore_shouldIncrementHighScore() {
        val game = Game()
        game.incrementScore()
        Assert.assertEquals("Score and HighScore don't match",
            1, game.highScore)
    }

    @Test
    fun mockClass() {
        val game = mockkClass(Game::class)
        given { game.highScore } returns 11
        //game.incrementScore()
        Assert.assertEquals(11, game.highScore)
        then { game.highScore }
    }
}
