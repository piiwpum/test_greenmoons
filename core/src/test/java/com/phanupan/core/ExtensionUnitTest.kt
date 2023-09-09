package com.phanupan.core

import exts.isPhoneNumber
import exts.toCelsius
import exts.toDateString
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExtensionUnitTest {

    @Test
    fun `toDateSting`() {
        assertEquals("Thu", 1625097600L.toDateString())
        assertEquals("01/07/2021", 1625097600L.toDateString("dd/MM/yyyy"))
        assertEquals("Sat", 1662825600L.toDateString())
    }

    @Test
    fun `isPhoneNumber`() {
        assertEquals(true, "0836220005".isPhoneNumber())
        assertEquals(true, "0916051123".isPhoneNumber())
        assertEquals(false, "0112232234".isPhoneNumber())
        assertEquals(false, "91238213123123123".isPhoneNumber())
    }

    @Test
    fun `toCelsius`() {
        val kelvin = 300.0
        assertEquals("26", kelvin.toCelsius())
    }



}