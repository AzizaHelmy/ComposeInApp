package com.example.composeinapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.composeinapp.composable.SpacerHorizontal16
import com.example.composeinapp.viewmodel.CounterViewModel

/**
 * Created by Aziza Helmy on 7/2/2023.
 */

@Composable
fun CounterScreen(viewModel: CounterViewModel = hiltViewModel()) {

    val counter by viewModel.state.collectAsState()
    CounterContent(
        counter = counter.toString(),
        onMinusClicked = viewModel::onDecreaseCounter,
        onPlusClicked = viewModel::onIncreaseCounter
    )
}

@Composable
private fun CounterContent(
    counter: String,
    onPlusClicked: () -> Unit,
    onMinusClicked: () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {

            Text(text = counter, fontSize = 96.sp)
            Row {
                Button(onClick = onMinusClicked) {
                    Text(text = "-", fontSize = 48.sp)
                }
                SpacerHorizontal16()
                Button(onClick = onPlusClicked) {
                    Text(text = "+", fontSize = 48.sp)
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewCounterScreen() {
    CounterScreen()
}