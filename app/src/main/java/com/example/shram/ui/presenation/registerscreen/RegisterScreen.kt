package com.example.shram.ui.presenation.registerscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Done
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.shram.models.UserRegisterDetails
import com.example.shram.ui.presenation.ShramViewModel


@Composable
fun RegisterScreen(
    modifier: Modifier = Modifier,
    shramViewModel: ShramViewModel
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        RegisterTextFiled(
            modifier = modifier.fillMaxSize(),
            onNameUpdate = {shramViewModel.registerDetail = shramViewModel.registerDetail.copy(name = it)},
            onAgeUpdate = {shramViewModel.registerDetail = shramViewModel.registerDetail.copy(age = it)},
            onNumberUpdate = {shramViewModel.registerDetail = shramViewModel.registerDetail.copy(number = it)},
            onGenderUpdate = {shramViewModel.registerDetail = shramViewModel.registerDetail.copy(gender = it)},
            onAddressUpdate = {shramViewModel.registerDetail = shramViewModel.registerDetail.copy(address = it)},
            onPasswordUpdate = {shramViewModel.registerDetail = shramViewModel.registerDetail.copy(password = it)},
            userRegisterDetails = shramViewModel.registerDetail
        )

        RegisterButton(
            onRegisterClicked = {shramViewModel.registerUser()}
        )
    }


}


@Composable
fun RegisterTextFiled(
    modifier: Modifier,
    onNameUpdate : (String) -> Unit,
    onAgeUpdate : (String) -> Unit,
    onNumberUpdate : (String) -> Unit,
    onGenderUpdate : (String) -> Unit,
    onAddressUpdate : (String) -> Unit,
    onPasswordUpdate : (String) -> Unit,
    userRegisterDetails: UserRegisterDetails
) {
    Column {
        //Name
        OutlinedTextField(
            value = userRegisterDetails.name,
            onValueChange = onNameUpdate,
            label = { Text(text = "Name")}
        )
        //Age
        OutlinedTextField(
            value = userRegisterDetails.age,
            onValueChange = {onAgeUpdate(it)},
            label = { Text(text = "Age")}
        )
        //Gender
        OutlinedTextField(
            value = userRegisterDetails.gender,
            onValueChange = {onGenderUpdate(it)},
            label = { Text(text = "Gender")}
        )
        //Address
        OutlinedTextField(
            value = userRegisterDetails.address,
            onValueChange = {onAddressUpdate(it)},
            label = { Text(text = "Address")}
        )
        //Phone
        OutlinedTextField(
            value = userRegisterDetails.number,
            onValueChange = {onNumberUpdate(it)},
            label = { Text(text = "Phone Number")}
        )
        //Password
        OutlinedTextField(
            value = userRegisterDetails.password,
            onValueChange = {onPasswordUpdate(it)},
            label = { Text(text = "Password")}
        )
    }
}

@Composable
fun RegisterButton(
    onRegisterClicked : () -> Unit
) {
    IconButton(onClick = onRegisterClicked ) {
        Icon(imageVector = Icons.TwoTone.Done, contentDescription = "Icone Done")
    }
}

