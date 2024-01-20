package com.example.shram.ui.presenation.shramscreen

import android.content.Context
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.twotone.Done
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.shram.R

import com.example.shram.models.shramdetails.RequestShramDetails
import com.example.shram.ui.navigation.Screen
import com.example.shram.ui.presenation.ShramViewModel
import com.example.shram.ui.shramUIState.ShramUiState



@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CreateShramDanScreen(
    shramViewModel: ShramViewModel,
    shramUiState: ShramUiState,
    navController: NavController,
    context:Context = LocalContext.current,
    modifier: Modifier = Modifier

) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()
    ) {
        //Title text
        Text(text = "Create Shram")
        //Image
        Image(painter = painterResource(id = R.drawable.welcome_kid_foreground), contentDescription = "Image")
        CreateSharamdanTextField(
            onTitleUpdate = {shramViewModel.createShramdan = shramViewModel.createShramdan.copy(title = it)},
            onDescriptionUpdate = {shramViewModel.createShramdan = shramViewModel.createShramdan.copy(description = it)},
            onDateChange = {shramViewModel.date = it},
            onTimeChange = {shramViewModel.userTime = it},
            onLocationUpdate = {shramViewModel.createShramdan = shramViewModel.createShramdan.copy(location = it)},
            createShramDetails = shramViewModel.createShramdan,
            date = shramViewModel.date,
            time = shramViewModel.userTime
        )
        CreateEventButton(
            onCreateButtonClicked = {
                val finalDate = shramViewModel.util.generateFormattedDateTime(date = shramViewModel.date, time = shramViewModel.userTime)
                shramViewModel.createShramdan = shramViewModel.createShramdan.copy(date = finalDate)
                shramViewModel.createShramdan = shramViewModel.createShramdan.copy(userId = shramUiState.loginResponse.userId)
                shramViewModel.createShramdanEvent()
                shramViewModel.getAllShram()
                Toast.makeText(context,"Event Creation Successful", Toast.LENGTH_SHORT).show()
                navController.navigate(route = Screen.ShramFeed.name)
            }
        )
    }
}

@Composable
fun CreateSharamdanTextField(
    modifier: Modifier = Modifier,
    onTitleUpdate : (String) -> Unit,
    onDescriptionUpdate : (String) -> Unit,
    onDateChange : (String) -> Unit,
    onTimeChange : (String) -> Unit,
    onLocationUpdate : (String) -> Unit,
    createShramDetails: RequestShramDetails,
    date : String,
    time: String
) {
    Column {
        //title
        OutlinedTextField(
            value = createShramDetails.title,
            onValueChange = {onTitleUpdate(it)},
            label = { Text(text = "Title")}
        )
        //Description
        OutlinedTextField(
            value = createShramDetails.description,
            onValueChange = {onDescriptionUpdate(it)},
            label = { Text(text = "Description")}
        )
        //Location Update
        OutlinedTextField(
            value = createShramDetails.location,
            onValueChange = {onLocationUpdate(it)},
            label = { Text(text = "Location")}
        )
        //Date
        OutlinedTextField(
            value = date,
            onValueChange = {onDateChange(it)},
            label = { Text(text = "Enter Date")}
        )

        //Time
        OutlinedTextField(
            value = time,
            onValueChange = {onTimeChange(it)},
            label = { Text(text = "Enter Time")}
        )
    }
}


@Composable
fun CreateEventButton(
    onCreateButtonClicked : () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onCreateButtonClicked,
        modifier = modifier.fillMaxWidth()
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = Icons.TwoTone.Done,
                contentDescription = "Icon Done"
            )
            Text(text = "Create Event")
        }

    }
}


