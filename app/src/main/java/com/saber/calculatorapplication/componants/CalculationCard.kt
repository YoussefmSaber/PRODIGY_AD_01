package com.saber.calculatorapplication.componants

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.saber.calculatorapplication.ui.theme.OperationScreenColor

@Composable
fun CalculationCard(equationText: String, resultText: String, historyText: List<String>) {
    Card(
        shape = RoundedCornerShape(24.dp),
        colors = CardColors(
            containerColor = OperationScreenColor,
            contentColor = Color.Unspecified,
            disabledContainerColor = Color.Unspecified,
            disabledContentColor = Color.Unspecified
        ),
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 8.dp,
        )
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
        ) {
            val (equation, result, history) = createRefs()
            // Display calculation history
            if (historyText.isNotEmpty()) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .constrainAs(history) {
                            top.linkTo(parent.top, margin = 16.dp)
                            start.linkTo(parent.start, margin = 16.dp)
                            end.linkTo(parent.end, margin = 16.dp)
                            bottom.linkTo(equation.top, margin = 8.dp)
                        }
                ) {
                    historyText.takeLast(6).forEach { historyItem ->
                        Text(
                            text = historyItem,
                            color = Color.Gray,
                            fontSize = 14.sp,
                            modifier = Modifier.padding(vertical = 4.dp)
                        )
                    }
                }
            }
            Text(
                text = resultText,
                color = Color.Black,
                fontSize = 35.sp,
                modifier = Modifier.constrainAs(result) {
                    bottom.linkTo(parent.bottom, margin = 16.dp)
                    end.linkTo(parent.end, margin = 16.dp)
                }
            )
            Text(
                text = equationText,
                fontSize = 18.sp,
                color = Color.Black,
                modifier = Modifier.constrainAs(equation) {
                    bottom.linkTo(result.top, margin = 8.dp)
                    end.linkTo(parent.end, margin = 16.dp)
                }
            )
        }
    }
}

