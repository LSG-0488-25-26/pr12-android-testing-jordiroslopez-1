package com.example.android_studio_test_exercice

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.compose.ui.state.ToggleableState
import com.example.android_studio_test_exercice.viewmodel.MainViewModel
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: MainViewModel

    @Before
    fun setup() {
        viewModel = MainViewModel()
    }

    @Test
    fun initialState() {
        assertTrue(viewModel.estatSwitch.value == true)
        assertTrue(viewModel.esVegetaria.value == false)
        assertTrue(viewModel.esVega.value == false)
        assertTrue(viewModel.esCarnivor.value == true)
        assertEquals(ToggleableState.Off, viewModel.triStateStatus.value)
        assertEquals("Messi", viewModel.selectedOption.value)
        assertEquals(0f, viewModel.sliderValue.value)
        assertTrue(viewModel.expanded.value == false)
        assertEquals("Opció A", viewModel.selectedItem.value)
        assertEquals("", viewModel.searchText.value)
        assertTrue(viewModel.showSnackbar.value == false)
        assertTrue(viewModel.toggleState.value == false)
    }

    @Test
    fun checkToggleEstatSwitch() {
        viewModel.toggleEstatSwitch()
        assertTrue(viewModel.toggleState.value == false)
    }

    @Test
    fun checkToggleEsCarnivor() {
        viewModel.toggleEsCarnivor()
        assertTrue(viewModel.esCarnivor.value == false)

        viewModel.toggleEsCarnivor()
        assertTrue(viewModel.esCarnivor.value == true)
    }

    @Test
    fun checkToggleEsVegetaria() {
        viewModel.toggleEsVegetaria()
        assertTrue(viewModel.esVegetaria.value == true)

        viewModel.toggleEsVegetaria()
        assertTrue(viewModel.esVegetaria.value == false)
    }

    @Test
    fun checkToggleEsVega() {
        viewModel.toggleEsVega()
        assertTrue(viewModel.esVega.value == true)

        viewModel.toggleEsVega()
        assertTrue(viewModel.esVega.value == false)
    }

    @Test
    fun checkToggleTriStateStatus() {
        viewModel.toggleTriStateStatus()
        assertEquals(ToggleableState.Indeterminate, viewModel.triStateStatus.value)

        viewModel.toggleTriStateStatus()
        assertEquals(ToggleableState.On, viewModel.triStateStatus.value)

        viewModel.toggleTriStateStatus()
        assertEquals(ToggleableState.Off, viewModel.triStateStatus.value)
    }

    @Test
    fun checkSelectedOption() {
        viewModel.setSelectedOption("Lamine Yamal")
        assertEquals("Lamine Yamal", viewModel.selectedOption.value)

        viewModel.setSelectedOption("Raphina")
        assertEquals("Raphina", viewModel.selectedOption.value)
    }

    @Test
    fun checkSliderValue() {
        viewModel.setSliderValue(67f)
        assertTrue(viewModel.sliderValue.value == 67f)

        viewModel.setSliderValue(33f)
        assertTrue(viewModel.sliderValue.value == 33f)

        viewModel.setSliderValue(69f)
        assertTrue(viewModel.sliderValue.value == 69f)
    }

    @Test
    fun checkExpand() {
        viewModel.setExpanded(true)
        assertTrue(viewModel.expanded.value == true)

        viewModel.setExpanded(false)
        assertTrue(viewModel.expanded.value == false)
    }

    @Test
    fun checkSelectedItem() {
        viewModel.setSelectedItem("Opció B")
        assertEquals("Opció B", viewModel.selectedItem.value)

        viewModel.setSelectedItem("Opció C")
        assertEquals("Opció C", viewModel.selectedItem.value)

        viewModel.setSelectedItem("Opció A")
        assertEquals("Opció A", viewModel.selectedItem.value)
    }

    @Test
    fun checkSearchText() {
        viewModel.setSearchText("Videos de gatitos")
        assertEquals("Videos de gatitos", viewModel.searchText.value)

        viewModel.setSearchText("Create mod tutorial")
        assertEquals("Create mod tutorial", viewModel.searchText.value)

        viewModel.setSearchText("Amazon Prime")
        assertEquals("Amazon Prime", viewModel.searchText.value)
    }

    @Test
    fun checkShowSnackbar() {
        viewModel.performSearch()
        assertEquals(true, viewModel.showSnackbar.value)
    }

    @Test
    fun checkToggleState() {
        viewModel.toggle()
        assertTrue(viewModel.toggleState.value == true)

        viewModel.toggle()
        assertTrue(viewModel.toggleState.value == false)
    }
}