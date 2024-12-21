package com.saber.calculatorapplication.view_model

import androidx.compose.runtime.mutableStateListOf
import net.objecthunter.exp4j.ExpressionBuilder
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

    // List to store calculation history
    private val _history = MutableStateFlow<List<String>>(emptyList())
    val history: StateFlow<List<String>> = _history

    fun onButtonClick(label: String) {
        when (label) {
            "=" -> calculateResult()
            "C" -> clearAll()
            "+/-" -> toggleSign()
            "%" -> applyPercentage()
            else -> appendToEquation(label)
        }
    }

    private fun appendToEquation(value: String) {
        if (value in listOf("÷", "×", "+")) {
            // If the equation is empty, don't allow an operator
            if (_equation.value.isEmpty()) return

            // Check if the last character is already an operator
            val lastChar = _equation.value.last()
            if (lastChar in listOf('÷', '×', '+')) {
                // Replace the last operator with the new one
                _equation.value = _equation.value.dropLast(1) + value
                return
            }
        }

        // Append the value to the equation
        _equation.value += value
    }

    private fun calculateResult() {
        try {
            val expression = _equation.value.replace("×", "*").replace("÷", "/").replace("−","-")
            val evalResult = evaluateExpression(expression)
            // Save the equation and result to history
            _history.value += "$expression = $evalResult"

            _result.value = evalResult.toString()
        } catch (e: Exception) {
            _result.value = "Error"
        }
    }

    private fun evaluateExpression(expression: String): Double {
        _equation.value = ""
        return ExpressionBuilder(expression).build().evaluate()
    }


    private fun clearAll() {
        _equation.value = ""
        _result.value = ""
    }

    private fun toggleSign() {
        if (_equation.value.isNotEmpty()) {
            val value = _equation.value.toDoubleOrNull()
            value?.let {
                _equation.value = (-it).toString()
            }
        }
    }

    private fun applyPercentage() {
        if (_equation.value.isNotEmpty()) {
            val value = _equation.value.toDoubleOrNull()
            value?.let {
                _equation.value = (it / 100).toString()
            }
        }
    }
}
