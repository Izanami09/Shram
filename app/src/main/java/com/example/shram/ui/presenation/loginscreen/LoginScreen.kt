package com.example.shram.ui.presenation.loginscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shram.R
import com.example.shram.ui.presenation.ShramViewModel

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    onLoginClick: () -> Unit,
    shramViewModel: ShramViewModel,
    onRegisterClick : () -> Unit
) {
    Column(
        modifier = modifier.padding(8.dp)
    ) {
        LoginImageHolder()
        LoginIntroText(
            modifier = Modifier.fillMaxWidth()
        )
        LoginInputFiled(
            modifier = Modifier.fillMaxWidth(),
            onNumberUpdate = {value -> shramViewModel.loginDetails = shramViewModel.loginDetails.copy(number = value)},
            onPasswordUpdate = {value -> shramViewModel.loginDetails = shramViewModel.loginDetails.copy(password = value)},
            number = shramViewModel.loginDetails.number,
            password = shramViewModel.loginDetails.password
        )
        LoginAndRegisterButton(
            modifier = Modifier.fillMaxWidth(),
            onLoginClick = onLoginClick,
            onRegisterClick = onRegisterClick
        )
    }
}

@Composable
fun LoginImageHolder(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(320.dp),
        contentAlignment = Alignment.Center
    ){
        Image(painter = painterResource(id = R.drawable.placeholder), contentDescription = "PlaceHolderImage" )
    }
}

@Composable
fun LoginIntroText(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ){
        Text(text = "Hello")
        Text(text = "Welcome to Shram")
    }
}

@Composable
fun LoginInputFiled(
    modifier: Modifier = Modifier,
    onNumberUpdate : (String) -> Unit,
    onPasswordUpdate : (String) -> Unit,
    number : String,
    password : String
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = number,
            onValueChange = {onNumberUpdate(it)},
            label = { Text(text = "Enter Your Phone Number")},
            modifier = Modifier.fillMaxWidth(),
            leadingIcon = { Icon(imageVector = Icons.Filled.Phone, contentDescription = "Phone")},
            keyboardActions = KeyboardActions {  },

        )
        OutlinedTextField(
            value = password,
            onValueChange = onPasswordUpdate,
            modifier = Modifier.fillMaxWidth(),
            label =  { Text(text = "Enter Your Password")},
            leadingIcon = { Icon(imageVector = Icons.Filled.Lock, contentDescription = "Lock Icon")}
        )
        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier.fillMaxWidth()
        ) {
            TextButton(onClick = { /*TODO*/ }) {
                Text(text = "Forgot Your Password")
            }
        }
    }
}

@Composable
fun LoginAndRegisterButton(
    modifier: Modifier = Modifier,
    onLoginClick : () -> Unit,
    onRegisterClick : () -> Unit
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedButton(onClick = onLoginClick) {
            Text(text = "Login")
        }
        OutlinedButton(onClick = onRegisterClick ) {
            Text(text = "Register")
        }
    }


}


