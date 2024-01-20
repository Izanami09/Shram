package com.example.shram.ui.presenation.mapscreen

import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType

data class MapState(
    val properties: MapProperties = MapProperties(
        isMyLocationEnabled = true,
        mapType = MapType.NORMAL
    ),
    val isFalloutMap: Boolean = false,

)
