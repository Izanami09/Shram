package com.example.shram.ui.presenation.mapscreen

import androidx.lifecycle.ViewModel
import com.example.shram.ui.shramUIState.ShramUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MapScreenViewModel: ViewModel() {
    private val _mapState = MutableStateFlow(MapState())
    val mapState : StateFlow<MapState>  =  _mapState.asStateFlow()


}