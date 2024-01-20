package com.example.shram.ui.presenation.mapscreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.google.maps.android.compose.GoogleMap

@Composable
fun MapScreen(
    mapsViewModel : MapScreenViewModel,
){
    val mapsUiState by mapsViewModel.mapState.collectAsState()
    GoogleMap(
        properties = mapsUiState.properties,
        onMapLoaded = {

        }
    ) {
    }
}