package com.saber.calculatorapplication.componants

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.saber.calculatorapplication.ui.theme.NumberButtonColor
import com.saber.calculatorapplication.ui.theme.OperatorButtonColor
import com.saber.calculatorapplication.ui.theme.TopRowColor

@Preview
@Composable
fun CalculatorButton(
    modifier: Modifier = Modifier,
    label: String = "C",
    onClick: () -> Unit = {}
) {
    val backgroundColor = when (label) {
        "÷", "×", "−", "+", "=" -> OperatorButtonColor // Operators
        "C", "+/-", "%" -> TopRowColor
        else -> NumberButtonColor
    }

    Button(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(containerColor = backgroundColor),
        elevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = 4.dp)
    ) {
        Text(
            text = label,
            fontSize = 18.sp,
            color = Color.White,
            modifier = Modifier.padding(vertical = 24.dp),
        )
    }
}