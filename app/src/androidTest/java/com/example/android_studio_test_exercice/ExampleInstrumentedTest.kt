package com.example.android_studio_test_exercice

import androidx.compose.runtime.internal.composableLambda
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsOff
import androidx.compose.ui.test.assertIsOn
import androidx.compose.ui.test.assertValueEquals
import androidx.compose.ui.test.hasClickAction
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.example.android_studio_test_exercice.viewmodel.MainViewModel

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@LargeTest
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun checkInitialComposableValues() {
        composeTestRule.onNodeWithTag("switchState_id").assertIsOn()
        composeTestRule.onNodeWithTag("checkCarnivor_id").assertIsOn()
        composeTestRule.onNodeWithTag("checkVegetaria_id").assertIsOff()
        composeTestRule.onNodeWithTag("checkVega_id").assertIsOff()
        composeTestRule.onNodeWithTag("searchButton_id").assert(hasClickAction())
        composeTestRule.onNodeWithTag("activateButton_id").assert(hasClickAction())
    }

    @Test
    fun checkCheckBoxMulti() {
        composeTestRule.onNodeWithTag("switchState_id").performClick()
        composeTestRule.onNodeWithTag("checkCarnivor_id").performClick()
        composeTestRule.onNodeWithTag("checkVegetaria_id").performClick()
        composeTestRule.onNodeWithTag("checkVega_id").performClick()
        composeTestRule.onNodeWithTag("searchButton_id").performClick()
        composeTestRule.onNodeWithTag("activateButton_id").performClick()
    }
}