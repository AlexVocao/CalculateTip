package com.example.calculatetip

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import org.junit.Rule
import org.junit.Test
import java.text.NumberFormat

class TipUITests {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun calculateTip_20PercentNoRoundUp() {
        composeTestRule.setContent {
            TipTimeLayout()
        }
        composeTestRule.onNodeWithText("Bill Amount")
            .assertExists("Bill amount field should exist")
            .performTextInput("100")

        composeTestRule.onNodeWithText("Tip Percentage")
            .assertExists("Tip percentage field should exist")
            .performTextInput("20")

        val expectedTip = NumberFormat.getCurrencyInstance().format(20.0)
        composeTestRule.onNodeWithText("Tip Amount: $expectedTip")
            .assertExists("Tip amount should exist")
    }
}