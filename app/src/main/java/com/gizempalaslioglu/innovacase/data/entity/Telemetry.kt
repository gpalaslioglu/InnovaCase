package com.gizempalaslioglu.innovacase.data.entity

import com.google.gson.annotations.SerializedName

data class Telemetry(
    @SerializedName("flight_club")
    val flightClub: String?
)