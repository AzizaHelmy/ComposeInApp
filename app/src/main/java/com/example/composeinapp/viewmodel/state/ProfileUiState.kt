package com.example.composeinapp.viewmodel.state

/**
 * Created by Aziza Helmy on 7/2/2023.
 */
data class ProfileUiState(
    val firstName: String = "",
    val lastName: String = "",
    val location: String = "",
    val email: String = "",
    val phone: String = "",
    val profilePictureLink: String = ""
)