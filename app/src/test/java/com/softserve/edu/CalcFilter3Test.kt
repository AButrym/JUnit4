package com.softserve.edu

import com.softserve.edu.service.Calc
import com.softserve.edu.service.CalcFilter
import com.softserve.edu.service.DigitalFilter
import io.mockk.OfTypeMatcher
import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkClass
import io.mockk.mockkConstructor
import io.mockk.mockkObject
import io.mockk.mockkStatic
import io.mockk.spyk
import io.mockk.verify
import org.junit.Assert
import org.junit.Test

class CalcFilter3Test {

    @Test
    fun checkSpy() {
        val calc = spyk(Calc())
        Assert.assertEquals(5.0,
            calc.add(2.0,3.0),
            0.001)
        verify { calc.add(2.0,3.0) }
        //
        every { calc.add(any(),any()) } returns 1.0
        val calcFilter = CalcFilter(calc)
        Assert.assertEquals("1.0",
            calcFilter.add("2","3"))
        //
        Assert.assertEquals(1.0,
            calc.sub(3.0,2.0), 0.001)
    }

    @Test
    fun checkRelaxed() {
        val calc = mockk<Calc>(relaxed = true)
        var res = calc.add(2.0,3.0)
        //
        println("res = $res")
        verify { calc.add(2.0,3.0) }
        //
        res = calc.sub(2.0,3.0)
        verify { calc.sub(2.0,3.0) }
    }

    @Test
    fun checkPartial() {
        val calc = mockk<Calc>()
        every { calc.add(any(),any()) } returns 1.0
        every { calc.add(2.0,3.0) } answers { callOriginal() }
        //
        Assert.assertEquals(1.0,
            calc.add(2.0,2.0),
            0.001)
        Assert.assertEquals(5.0,
            calc.add(2.0,3.0),
            0.001)
    }

    object ObjBeingMocked {
        fun add(a: Int, b: Int) = a + b
    }

    @Test
    fun checkObject() {
        mockkObject(ObjBeingMocked) // applies mocking to an Object
        Assert.assertEquals(3, ObjBeingMocked.add(1, 2))
        //
        every { ObjBeingMocked.add(3, 2) } returns 1
        Assert.assertEquals(1, ObjBeingMocked.add(3, 2))
    }

    @Test
    fun checkClass() {
        val calc = mockkClass(Calc::class)
        every { calc.add(any(),any()) } returns 1.0
        //
        Assert.assertEquals(1.0,
            calc.add(2.0,2.0),
            0.001)
        verify { calc.add(2.0,2.0) }
    }

    enum class Enumeration(val someInt: Int) {
        CONSTANT(3),
        OTHER_CONSTANT(2);
    }

    @Test
    fun checkEnum() {
        mockkObject(Enumeration.CONSTANT)
        every { Enumeration.CONSTANT.someInt } returns 1
        //
        Assert.assertEquals(1,
            Enumeration.CONSTANT.someInt)
        verify { Enumeration.CONSTANT.someInt }
    }

    @Test
    fun checkConstructor() {
        mockkConstructor(Calc::class)
        every { anyConstructed<Calc>().add(3.0, 2.0) } returns 1.0
        //
        Assert.assertEquals(1.0,
            Calc().add(3.0, 2.0), 0.001)
        verify { anyConstructed<Calc>().add(3.0, 2.0) }
    }

    @Test
    fun checkAnotherConstructor() {
        mockkConstructor(Calc::class)
        every { constructedWith<Calc>(OfTypeMatcher<Double>(
            Double::class)).add(3.0, 2.0) } returns 1.0
        every { constructedWith<Calc>(OfTypeMatcher<Double>(
            Double::class)).add(3.0) } returns 1.0
        //
        Assert.assertEquals(1.0,
            Calc().add(3.0, 2.0), 0.001)
        Assert.assertEquals(1.0,
            Calc(2.0).add(3.0), 0.001)
        //
        verify { constructedWith<Calc>(OfTypeMatcher<Double>(
            Double::class)).add(3.0, 2.0) }
        verify { constructedWith<Calc>(OfTypeMatcher<Double>(
            Double::class)).add(3.0) }
    }

    @Test
    fun checkMockBaseClassConstructor() {
        mockkConstructor(Calc::class)
        every { anyConstructed<Calc>().add(3.0, 2.0) } returns 1.0
        //
        val calcFilter = CalcFilter()
        Assert.assertEquals("1.0",
            calcFilter.add("3","2"))
    }

    @Test
    fun checkAtLeastAtMost() {
        val calc = mockk<Calc>(relaxed = true)
        calc.add(2.0,3.0)
        calc.add(2.0,2.0)
        calc.add(3.0,2.0)
        //
        verify(atLeast = 3) { calc.add(allAny(), allAny()) }
        verify(atMost  = 2) { calc.add(2.0, or(2.0, 3.0)) }
        verify(exactly = 1) { calc.add(3.0, 2.0) }
        verify(exactly = 0) { calc.add(3.0, 1.0) }
        //
        confirmVerified(calc)
    }

    @Test
    fun checkTopLevel() {
        mockkStatic(::DigitalFilter)
        every { DigitalFilter(any()) } returns "1"
        //
        Assert.assertEquals("1",
            DigitalFilter("1abc2efd3"))
        verify { DigitalFilter("1abc2efd3") }
    }
}
