package com.example.composeinapp.viewmodels

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

/**
 * Created by Aziza Helmy on 7/2/2023.
 */
@HiltViewModel
class CounterViewModel : ViewModel() {
    private val _state = MutableStateFlow(0)
    val state = _state.asStateFlow()


    fun onIncreaseCounter() {
        _state.update { it + 1 }
    }

    fun onDecreaseCounter() {
        _state.update { it - 1 }
    }
}