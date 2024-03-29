package com.example.composeinapp.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.example.composeinapp.ui.theme.CardBackgroundColor
import com.example.composeinapp.ui.theme.Rubik
import com.example.composeinapp.viewmodel.FoodViewModel
import com.example.composeinapp.viewmodel.state.FoodUiState
import com.example.composeinapp.viewmodel.state.MealUiState
import com.example.composeinapp.viewmodel.state.RestaurantUiState

/**
 * Created by Aziza Helmy on 7/2/2023.
 */

@Composable
fun FoodScreen(viewModel: FoodViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsState()
    FoodContent(state = state, onClickMeal = viewModel::onClickMeal)
    //LazyGridFoodContent(state = state, onClickMeal = viewModel::onClickMeal)
    //AdaptiveLazyGridFoodContent(state = state, onClickMeal = viewModel::onClickMeal)
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun AdaptiveLazyGridFoodContent(
    state: FoodUiState,
    onClickMeal: (MealUiState) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 128.dp),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
 item(span = {
            GridItemSpan(3)
        }) {
            Text(text = "Menu")
        }
        items(items = state.meals, key = { currentMeal -> currentMeal.name }) {
            MealItem(
                meal = it,
                onClick = onClickMeal,
                modifier = Modifier
                    .animateItemPlacement()
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun LazyGridFoodContent(
    state: FoodUiState,
    onClickMeal: (MealUiState) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item(span = {
            GridItemSpan(3)
        }) {
            Text(text = "Menu")
        }
        items(items = state.meals, key = { currentMeal -> currentMeal.name }) {
            MealItem(
                meal = it,
                onClick = onClickMeal,
                modifier = Modifier
                    .animateItemPlacement()
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun FoodContent(state: FoodUiState, onClickMeal: (MealUiState) -> Unit) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text(text = "My Favorites Akl 😋", modifier = Modifier.padding(16.dp))
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(horizontal = 16.dp)
            ) {
                items(state.restaurants) {
                    RestaurantItem(restaurant = it)
                }
            }
        }
        items(items = state.meals, key = { currentMeal -> currentMeal.name }) {
            MealItem(
                meal = it, onClick = onClickMeal,
                modifier = Modifier
                    .animateItemPlacement()
            )
        }
        item {
            MealsHeader(title = "EasternMeals:")
        }
        items(items = state.easternMeals, key = { currentMeal -> currentMeal.name }) {
            MealItem(meal = it, onClick = onClickMeal, modifier = Modifier.animateItemPlacement())
        }
        stickyHeader { MealsHeader(title = "WesternMeals:") }
        items(items = state.westernMeals, key = { currentMeal -> currentMeal.name }) {
            MealItem(
                meal = it,
                onClick = onClickMeal,
                modifier = Modifier
                    .animateItemPlacement()
            )
        }
        item {
            Text(text = "Salaaam")
        }
    }
}

@Composable
private fun MealsHeader(title: String) {
    Text(
        text = title,
        modifier = Modifier
            .fillMaxWidth()
            .background(CardBackgroundColor)
            .padding(8.dp)
    )
}

@Composable
fun LargeTextItem(text: String, color: Color) {
    Text(
        text = text,
        fontFamily = Rubik,
        fontWeight = FontWeight.Normal,
        fontSize = 28.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp)
            .background(color = color)

    )
}

@Composable
fun MealItem(meal: MealUiState, onClick: (MealUiState) -> Unit, modifier: Modifier) {
    Card(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(modifier = modifier.clickable { onClick(meal) }) {
            Image(
                painter = rememberAsyncImagePainter(model = meal.imageUrl),
                contentDescription = "Food Image",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
            Text(
                text = meal.name,
                fontFamily = Rubik,
                fontWeight = FontWeight.Normal,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(CardBackgroundColor)
                    .padding(16.dp)

            )
        }
    }
}

@Composable
fun RestaurantItem(restaurant: RestaurantUiState) {
    Image(
        painter = rememberAsyncImagePainter(model = restaurant.imageUrl),
        contentDescription = "RestaurantItem Image",
        contentScale = ContentScale.Crop,
        alignment = Alignment.Center,
        modifier = Modifier
            .size(96.dp)
            .clip(CircleShape)
            .background(
                color = Color(0xFFF8F8F8F)
            ),
    )

}

@Preview
@Composable
fun PreviewMealItem() {
    MealItem(
        meal = MealUiState(
            "Ahmed",
            "https://www.eatthis.com/wp-content/uploads/sites/4/media/images/ext/796412456/grilled-cheese-tomato-soup.jpg?quality=82&strip=1"
        ),
        onClick = {},
        modifier = Modifier
    )
}