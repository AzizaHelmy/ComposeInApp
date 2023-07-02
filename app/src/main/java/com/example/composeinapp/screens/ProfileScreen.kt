package com.example.composeinapp.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.example.composeinapp.R
import com.example.composeinapp.composable.DefaultButton
import com.example.composeinapp.composable.Header
import com.example.composeinapp.composable.InformationCard
import com.example.composeinapp.composable.ProfileAvatar
import com.example.composeinapp.composable.SpacerHorizontal16
import com.example.composeinapp.composable.SpacerVertical24
import com.example.composeinapp.composable.SpacerVertical32
import com.example.composeinapp.composable.TextButton
import com.example.composeinapp.viewmodel.ProfileViewModel
import com.example.composeinapp.viewmodel.state.ProfileUiState


/**
 * Created by Aziza Helmy on 7/1/2023.
 */
@Composable
fun ProfileScreen(viewModel: ProfileViewModel = hiltViewModel()) {

    val state by viewModel.state.collectAsState()

    ProfileContent(
        state = state,
        onChangeFirstName = viewModel::onChangeFirstName,
        onChangeLastName = viewModel::onChangeLastName,
        onChangeEmail = viewModel::onChangeEmail,
        onChangeLocation = viewModel::onChangeLocation,
        onChangePhone = viewModel::onChangePhone,
        saveUserInfo = viewModel::saveUserInformation
    )
}

@Composable
private fun ProfileContent(
    state: ProfileUiState,
    onChangeFirstName: (String) -> Unit,
    onChangeLastName: (String) -> Unit,
    onChangeLocation: (String) -> Unit,
    onChangeEmail: (String) -> Unit,
    onChangePhone: (String) -> Unit,
    saveUserInfo: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Header(
            title = stringResource(R.string.account),
            subTitle = stringResource(R.string.edit_or_manage_your_account)
        )
        SpacerVertical32()
        ProfileAvatar(painter = rememberAsyncImagePainter(model = state.profilePictureLink))
        SpacerVertical24()
        TextButton(text = stringResource(R.string.change_profile_picture)) {}
        SpacerVertical32()
        Row {
            Box(modifier = Modifier.weight(1f)) {
                InformationCard(
                    title = stringResource(R.string.firstname),
                    information = state.firstName,
                    onTextChange = onChangeFirstName
                )
            }
            SpacerHorizontal16()
            Box(modifier = Modifier.weight(1f)) {
                InformationCard(
                    title = stringResource(R.string.lastname),
                    information = state.lastName,
                    onTextChange = onChangeLastName
                )
            }
        }
        InformationCard(
            title = stringResource(R.string.location),
            information = state.location, onTextChange = onChangeLocation
        )
        InformationCard(
            title = stringResource(R.string.email),
            information = state.email, onTextChange = onChangeEmail
        )
        InformationCard(
            title = stringResource(R.string.phone_number),
            information = state.phone,
            onTextChange = onChangePhone
        )
        Spacer(modifier = Modifier.weight(1f))
        DefaultButton(text = stringResource(R.string.save), onClick = saveUserInfo)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProfileScreen() {
   // ProfileContent()
}