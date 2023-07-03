package com.example.composeinapp.screens

import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

/**
 * Created by Aziza Helmy on 7/3/2023.
 */
@Composable
fun TestConstraint() {
    ConstraintLayout() {
        val (button, fab, text) = createRefs()
        val horizontalGuideLine = createGuidelineFromTop(0.13f)
        //val chain = createHorizontalChain(button, text)

        Button(onClick = { },
            modifier = Modifier.constrainAs(button) {
//                top.linkTo(parent.top)
//                bottom.linkTo(parent.bottom)
                top.linkTo(horizontalGuideLine)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }) {}
        FloatingActionButton(
            onClick = {},
            modifier = Modifier.constrainAs(fab) {
                bottom.linkTo(parent.bottom, 32.dp)
                end.linkTo(parent.end, 32.dp)
            }) {}
        Text(text = "Hello Ah. ", modifier = Modifier.constrainAs(text) {
            top.linkTo(button.bottom, 32.dp)
            start.linkTo(button.start)
            end.linkTo(button.end)
        })
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewTestConstraint() {
    TestConstraint()
}