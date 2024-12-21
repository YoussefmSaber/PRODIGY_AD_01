package com.saber.calculatorapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.saber.calculatorapplication.componants.CalculationCard
import com.saber.calculatorapplication.componants.CalculatorButtonPad
import com.saber.calculatorapplication.constatns.usedValues
import com.saber.calculatorapplication.ui.theme.BackgroundColor
import com.saber.calculatorapplication.ui.theme.CalculatorApplicationTheme
import com.saber.calculatorapplication.view_model.CalculatorViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculatorApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CalculatorApp(innerPadding)
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun CalculatorApp(
    innerPadding: PaddingValues = PaddingValues(32.dp),
    viewModel: CalculatorViewModel = hiltViewModel()
) {
    // Safely collect StateFlow values
    val equation by viewModel.equation.collectAsState()
    val result by viewModel.result.collectAsState()
    val history by viewModel.history.collectAsState()
    Column(
        modifier = Modifier
            .background(BackgroundColor)
            .fillMaxSize()
            .padding(vertical = innerPadding.calculateTopPadding(), horizontal = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(32.dp))
        CalculationCard(equation, result, history)
        Spacer(modifier = Modifier.height(24.dp))
        CalculatorButtonPad(buttons = usedValues.chunked(4)) {
            viewModel.onButtonClick(it)
        }
    }
}