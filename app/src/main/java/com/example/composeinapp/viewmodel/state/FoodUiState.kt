package com.example.composeinapp.viewmodel.state


/**
 * Created by Aziza Helmy on 7/2/2023.
 */
data class FoodUiState(
    val restaurants: List<RestaurantUiState> = emptyList(),
    val meals: List<MealUiState> = emptyList(),
    val easternMeals: List<MealUiState> = emptyList(),
    val westernMeals: List<MealUiState> = emptyList()
)

data class MealUiState(
    val name: String,
    val imageUrl: String
)

data class RestaurantUiState(
    val name: String,
    val imageUrl: String
)
