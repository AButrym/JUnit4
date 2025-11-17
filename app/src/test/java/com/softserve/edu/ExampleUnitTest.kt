package com.softserve.edu

import com.google.common.truth.Truth.assertThat
import com.google.common.truth.Truth.assertWithMessage
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    // truth
    @Test
    fun truthAddition() {
        assertThat(2 + 2)
            .isEqualTo(4)
    }

    @Test
    fun truthMessage() {
        val string = "awesome"
        assertThat(string).startsWith("awe")
        assertWithMessage("Without me, it's just aweso")
            .that(string)
            .contains("me")
    }

    @Test
    fun truthList() {
        val listColors = listOf("blue", "red", "yellow", "blue", "green", "red")
        assertThat(listColors)
            .containsExactly("blue", "red", "yellow", "blue", "green", "red")
            .inOrder()
    }

    @Test
    fun truthContainsText() {
        val text = "truth"
        val anotherText = "AssertJ"
        //
        assertThat(text)
            .contains("tru");
        assertThat(text)
            .isEqualTo("truth")
        assertThat(text)
            .isNotSameInstanceAs(anotherText)
        assertThat(text)
            .hasLength(5)
    }

    @Test
    fun truthContainsList() {
        val listDigits = listOf(1, 2, 3, 4, 5)
        //
        assertThat(listDigits)
            .containsAnyOf(2, 4, 3)
        assertThat(listDigits)
            .containsNoDuplicates()
        assertThat(listDigits)
            .doesNotContain(7)
        assertThat(listDigits)
            .hasSize(5)
    }
}
