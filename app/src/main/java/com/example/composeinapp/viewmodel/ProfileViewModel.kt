package com.example.composeinapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.composeinapp.viewmodel.state.ProfileUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

/**
 * Created by Aziza Helmy on 7/2/2023.
 */
@HiltViewModel
class ProfileViewModel : ViewModel() {

    private val _state = MutableStateFlow(ProfileUiState())
    val state = _state.asStateFlow()

    init {
        getUserInfo()
    }

    private fun getUserInfo() {
        // _state.update { it.copy(profilePictureLink = "https://wallpapers.com/images/hd/cool-profile-picture-87h46gcobjl5e4xu.jpg") }
        _state.update { it.copy(profilePictureLink = "https://freerangestock.com/sample/125944/old-woman-in-white-hijab-.jpg") }

        //from use case
    }

    fun onChangeFirstName(newValue: String) {
        _state.update { it.copy(firstName = newValue) }
    }

    fun onChangeLastName(newValue: String) {
        _state.update { it.copy(lastName = newValue) }
    }

    fun onChangeEmail(newValue: String) {
        _state.update { it.copy(email = newValue) }
    }

    fun onChangeLocation(newValue: String) {
        _state.update { it.copy(location = newValue) }
    }

    fun onChangePhone(newValue: String) {
        _state.update { it.copy(phone = newValue) }
    }

    fun saveUserInformation() {
        //saveUserInfoUseCase
    }

}