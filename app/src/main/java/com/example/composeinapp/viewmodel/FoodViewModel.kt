package com.example.composeinapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.composeinapp.viewmodel.state.FoodUiState
import com.example.composeinapp.viewmodel.state.MealUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

/**
 * Created by Aziza Helmy on 7/2/2023.
 */
@HiltViewModel
class FoodViewModel : ViewModel() {

    private val _state = MutableStateFlow(FoodUiState())
    val state = _state.asStateFlow()

    init {
        getFoods()
    }

    private fun getFoods() {
        _state.update {
            it.copy(
                meals = listOf(
                    MealUiState(
                        "Humborgar",
                        "https://images.immediate.co.uk/production/volatile/sites/30/2020/08/chorizo-mozarella-gnocchi-bake-cropped-9ab73a3.jpg?quality=90&resize=960,872"
                    ),
                    MealUiState(
                        "Seso",
                        "https://anestisxasapotaverna.gr/wp-content/uploads/2021/12/ARTICLE-1.jpg"
                    ),
                    MealUiState(
                        "Mozzela",
                        "https://interactive.wttw.com/sites/default/files/food-landing-page-hero_01.jpg"
                    ),
                    MealUiState(
                        "Nano",
                        "https://a.cdn-hotels.com/gdcs/production0/d1513/35c1c89e-408c-4449-9abe-f109068f40c0.jpg?impolicy=fcrop&w=800&h=533&q=medium"
                    ),
                    MealUiState(
                        "XYZZ",
                        "https://tekce.net/files/upload/images/spanish-best-cousines-1.jpg"
                    ),
                    MealUiState(
                        "Tmatemo",
                        "https://wpstaq-ap-southeast-2-media.s3.amazonaws.com/liver-foundation/wp-content/uploads/media/2022/11/healthy-food.jpg"
                    ),
                    MealUiState(
                        "Saryw",
                        "https://static01.nyt.com/images/2021/02/17/dining/17tootired-grilled-cheese/17tootired-grilled-cheese-articleLarge.jpg?quality=75&auto=webp&disable=upscale"
                    ),
                    MealUiState(
                        "Sandwatch",
                        "https://www.eatthis.com/wp-content/uploads/sites/4/media/images/ext/796412456/grilled-cheese-tomato-soup.jpg?quality=82&strip=1"
                    ),


                    )
            )
        }
    }

    fun onClickMeal(meal: MealUiState) {

    }

}