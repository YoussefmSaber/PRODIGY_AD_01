package com.saber.calculatorapplication

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class CalculatorViewModel @Inject constructor() : ViewModel() {
    private val _equation = MutableStateFlow("")
    val equation: StateFlow<String> = _equation

    private val _result = MutableStateFlow("")
    val result: StateFlow<String> = _result

    fun onButtonClick(input: String) {
        // Update equation or result based on input
        if (input == "=") {
            calculateResult()
        } else {
            _equation.value += input
        }
    }

    private fun calculateResult() {
        try {
            // Dummy calculation logic
            _result.value = _equation.value // Replace with real calculation logic
        } catch (e: Exception) {
            _result.value = "Error"
        }
    }

    fun clearAll() {
        _equation.value = ""
        _result.value = ""
    }
}