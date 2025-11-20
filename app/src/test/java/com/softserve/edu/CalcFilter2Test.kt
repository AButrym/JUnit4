package com.softserve.edu

import com.softserve.edu.service.Calc
import com.softserve.edu.service.CalcFilter
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.junit4.MockKRule
import io.mockk.just
import io.mockk.runs
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

class CalcFilter2Test {

    @get:Rule
    val mockkRule = MockKRule(this)
//    init {
//        MockKAnnotations.init(this, relaxUnitFun = true)
//    }

    @MockK
    lateinit var game1: Game

    @RelaxedMockK
    lateinit var calc2: Calc

    @Test
    fun something() {
        every { game1.incrementScore() } just runs
        every { calc2.add(any(),any()) } returns 1.0
        Assert.assertEquals(1.0,
            calc2.add(2.0,3.0),
            0.001)
        //
        val calcFilter = CalcFilter(calc2)
        Assert.assertEquals("1.0",
                calcFilter.add("2","3"))
    }

}
