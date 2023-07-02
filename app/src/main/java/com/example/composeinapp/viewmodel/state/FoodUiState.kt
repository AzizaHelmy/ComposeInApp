package com.example.composeinapp.viewmodel.state


/**
 * Created by Aziza Helmy on 7/2/2023.
 */
data class FoodUiState(val meals: List<MealUiState> = emptyList())

data class MealUiState(
    val name: String ,
    val imageUrl: String
)
