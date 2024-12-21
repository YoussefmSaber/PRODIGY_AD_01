package com.saber.calculatorapplication.componants

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.saber.calculatorapplication.ui.theme.OperationScreenColor

@Composable
fun CalculationCard(equationText: String, resultText: String) {
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
            val (equation, result) = createRefs()
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

