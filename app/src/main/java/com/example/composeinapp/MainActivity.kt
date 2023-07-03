package com.example.composeinapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.composeinapp.screens.TestConstraint

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //CounterScreen()
            //ProfileScreen()
            //FoodScreen()
            TestConstraint()
        }
    }
}
