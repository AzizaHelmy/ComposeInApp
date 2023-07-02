package com.example.composeinapp.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.composeinapp.ui.theme.PrimaryTextColor
import com.example.composeinapp.ui.theme.Rubik
import com.example.composeinapp.ui.theme.SecondaryTextColor

/**
 * Created by Aziza Helmy on 7/1/2023.
 */
@Composable
fun Header(title: String, subTitle: String) {
    Column(modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start) {
        Text(
            text = title,
            fontFamily = Rubik,
            fontWeight = FontWeight.Medium,
            fontSize = 18.sp,
            color = PrimaryTextColor
        )
        Text(
            text = subTitle,
            fontFamily = Rubik,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            color = SecondaryTextColor
        )

    }
}

@Composable
@Preview(widthDp = 360)
fun PreviewHeader() {
    Header(title = "Ahmed", subTitle = "Aziza")
}