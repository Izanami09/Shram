package com.example.shram.ui.presenation.homescreen

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.twotone.PlayArrow
import androidx.compose.material.icons.twotone.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shram.R
import com.example.shram.models.LoginResponse
import com.example.shram.ui.presenation.ShramViewModel
import com.example.shram.ui.shramUIState.ShramUiState

@Composable
fun HomeScreen(
    viewModel: ShramViewModel,
    uiState: ShramUiState,
    onExploringButtonClicked: () -> Unit,
    onLoginOrSignupClicked: () -> Unit
) {

    UserNameAndGreeting(
        loginResponse = uiState.loginResponse,
        isUserLoggedIn = uiState.isUserLoggedIn,
        onExploringButtonClicked = onExploringButtonClicked,
        onLoginOrSignupClicked = onLoginOrSignupClicked
    )
    //FavouriteSection()
    //TreePlantation()
}

@Composable
fun UserNameAndGreeting(
    modifier : Modifier = Modifier,
    loginResponse: LoginResponse,
    isUserLoggedIn : Boolean,
    onLoginOrSignupClicked : () -> Unit,
    onExploringButtonClicked : () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(320.dp),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.welcome_kid_foreground),
                contentDescription = "Welcome Kid",
                modifier = Modifier.height(160.dp)
            )
            Column(
                modifier = Modifier.padding(16.dp)
            ){
                Text(
                    text = "Hello,",
                    fontSize = MaterialTheme.typography.titleLarge.fontSize,
                    fontWeight = MaterialTheme.typography.displayLarge.fontWeight,
                    fontFamily = MaterialTheme.typography.titleLarge.fontFamily,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(text = "${loginResponse.name}!")
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Are you ready for some shramdan?")
            }
        }
        if (isUserLoggedIn == false){
            OutlinedButton(onClick = onLoginOrSignupClicked ) {
                Text(text = "Login / Register")
            }
        }
            IconButton(
                onClick = onExploringButtonClicked,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(imageVector = Icons.TwoTone.PlayArrow, contentDescription = "Let's Go")
                    Text(text = "Continue Exploring Some Shram Feed")
                }

            }
        }
    }
@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    UserNameAndGreeting(
        loginResponse = ShramUiState().loginResponse,
        isUserLoggedIn = false,
        onLoginOrSignupClicked = { /*TODO*/ }) {
        
    }
    
}