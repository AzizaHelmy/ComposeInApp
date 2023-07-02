package com.example.composeinapp.composable

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.composeinapp.ui.theme.Orange
import com.example.composeinapp.ui.theme.Rubik


/**
 * Created by Aziza Helmy on 7/1/2023.
 */
@Composable
fun TextButton(text: String, onClick: () -> Unit) {
    Text(
        text = text,
        fontFamily = Rubik,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        color = Orange,
        modifier = Modifier.clickable {
            onClick
        }
    )
}