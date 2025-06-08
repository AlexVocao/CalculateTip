package com.example.calculatetip

import androidx.compose.runtime.saveable.autoSaver
import org.junit.Test
import java.text.NumberFormat


class TipCalculatorTests {
    @Test
    fun calculateTip_20PercentNoRoundUp() {
        // Given
        val amount = 100.0
        val tipPercentage = 20.0
        val roundUp = false

        // When
        val actualTip = calculateTip(amount, tipPercentage, roundUp)
        val expectedTip = NumberFormat.getCurrencyInstance().format(20)

        // Then
        assert(actualTip == expectedTip) {
            "Expected $expectedTip but got $actualTip"
        }
    }
}