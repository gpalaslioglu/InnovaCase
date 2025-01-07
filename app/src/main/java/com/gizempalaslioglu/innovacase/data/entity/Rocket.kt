package com.gizempalaslioglu.innovacase.data.entity

import com.google.gson.annotations.SerializedName

data class Rocket(
    @SerializedName("fairings")
    val fairings: Fairings?,
    @SerializedName("first_stage")
    val firstStage: FirstStage?,
    @SerializedName("rocket_name")
    val rocketName: String?,
    @SerializedName("rocket_type")
    val rocketType: String?,
    @SerializedName("rocket_id")
    val rocketId: String?,
    @SerializedName("second_stage")
    val secondStage: SecondStage?
)