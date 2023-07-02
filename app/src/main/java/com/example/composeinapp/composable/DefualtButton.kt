package com.example.composeinapp.composable

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeinapp.ui.theme.Green
import com.example.composeinapp.ui.theme.Rubik

/**
 * Created by Aziza Helmy on 7/1/2023.
 */
@Composable
fun DefaultButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = { }, modifier = Modifier
            .fillMaxWidth()
            .height(54.dp),
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(Green),
        elevation = ButtonDefaults.buttonElevation(0.dp)
    ) {
        Text(
            text = text,
            fontFamily = Rubik,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            color = Color.White,

            )
    }
}