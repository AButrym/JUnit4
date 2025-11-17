package com.softserve.edu

import com.softserve.edu.service.Calc
import com.softserve.edu.service.CalcFilter
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.impl.annotations.SpyK
import io.mockk.junit4.MockKRule
import io.mockk.mockkClass
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CalcFilter1Test {

    @MockK
    lateinit var calc1: Calc

    @RelaxedMockK
    lateinit var calc2: Calc

    @MockK(relaxUnitFun = true)
    lateinit var calc3: Calc

    @SpyK
    var calc4 = Calc()

    //@InjectMockKs
    //var calcFilter = CalcFilter(calc1)

    // turn relaxUnitFun on for all mocks
    @Before
    fun setUp() = MockKAnnotations.init(this, relaxUnitFun = true)

    @Test
    fun checkAdds() {
        //calc1 = mockkClass(Calc::class)
        every { calc1.add(any(),any()) } returns 1.0
        Assert.assertEquals(1.0,
            calc1.add(2.0,3.0),
            0.001)
    }

}
