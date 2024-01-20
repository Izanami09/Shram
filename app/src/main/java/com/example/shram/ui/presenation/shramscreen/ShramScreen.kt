package com.example.shram.ui.presenation.shramscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shram.R
import com.example.shram.models.shramdetails.ResponseShramDetails
import com.example.shram.models.shramdetails.ShramDetails
import com.example.shram.ui.presenation.ShramViewModel
import com.example.shram.ui.shramUIState.ShramUiState

@Composable
fun ShramScreen(
    viewModel: ShramViewModel,
    shramUiState: ShramUiState,
    onCreateEventClick : () -> Unit
) {
    Column{
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Current Shramdan",
                fontSize = MaterialTheme.typography.titleMedium.fontSize,
                fontWeight = MaterialTheme.typography.titleMedium.fontWeight
            )
            OutlinedButton( onClick = onCreateEventClick ) {
                Text(text = "Create Event")
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        ShramFeed(
            listOfShram = shramUiState.allShram
        )
    }

}

fun getGradient(
    startColor: Color,
    endColor: Color,
): Brush {
    return Brush.horizontalGradient(
        colors = listOf(startColor, endColor)
    )
}

@Composable
fun ShramItem(
    shramDetails: ShramDetails,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp)
        ) {
            Column(
                modifier = Modifier
                    .clip(RoundedCornerShape(25.dp))
                    .background(getGradient(Color.Green, Color.Blue))
                    .height(320.dp)
                    .clickable {}
                    .padding(vertical = 12.dp, horizontal = 16.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {

                Image(
                    painter = painterResource(id = R.drawable.placeholder),
                    contentDescription = shramDetails.title,
                    modifier = Modifier.width(60.dp)
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = shramDetails.title,
                    color = Color.White,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = shramDetails.description,
                    color = Color.White,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = shramDetails.location,
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )

            }
        }
}

@Composable
fun ShramFeed(
    listOfShram : ResponseShramDetails,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ){
        items(listOfShram.jobs){
            ShramItem(
                shramDetails = it,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}