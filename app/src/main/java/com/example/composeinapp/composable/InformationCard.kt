package com.example.composeinapp.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeinapp.ui.theme.CardBackgroundColor
import com.example.composeinapp.ui.theme.Rubik
import com.example.composeinapp.ui.theme.SecondaryTextColor

/**
 * Created by Aziza Helmy on 7/1/2023.
 */
@Composable
fun InformationCard(title: String, information: String, onTextChange: (String) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = CardBackgroundColor),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Column(modifier = Modifier.padding(horizontal = 24.dp, vertical = 16.dp)) {
            Text(
                text = title,
                fontFamily = Rubik,
                fontWeight = FontWeight.Normal,
                fontSize = 9.sp,
                color = SecondaryTextColor,
            )
            /* Text(
                 text = information,
                 fontFamily = Rubik,
                 fontWeight = FontWeight.Normal,
                 fontSize = 14.sp,
                 color = PrimaryTextColor,
             )*/
            BasicTextField(value = information, onValueChange =onTextChange)
        }
    }
}

@Preview
@Composable
fun previewInformationCard() {
   // InformationCard(title = "", information = "")
}