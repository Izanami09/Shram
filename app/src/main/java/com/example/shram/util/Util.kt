package com.example.shram.util

import android.os.Build
import androidx.annotation.RequiresApi
import com.google.android.gms.maps.model.LatLng
import kotlinx.coroutines.flow.Flow
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.util.Locale
import javax.inject.Inject

class Util {
    @RequiresApi(Build.VERSION_CODES.O)
    fun generateFormattedDateTime(date: String, time: String): String {
        val userInput : String = date.plus(" ").plus(time)
        // Assuming userInput is in the format "yyyy-MM-dd HH:mm:ss"
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH)
        val localDateTime = LocalDateTime.parse(userInput, formatter)

        // Convert LocalDateTime to OffsetDateTime with UTC offset
        val offsetDateTime = localDateTime.atOffset(ZoneOffset.UTC)

        // Format OffsetDateTime to the desired format
        val outputFormatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME
        return offsetDateTime.format(outputFormatter)
    }
}
