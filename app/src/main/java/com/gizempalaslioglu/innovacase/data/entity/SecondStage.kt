package com.gizempalaslioglu.innovacase.data.entity

import com.google.gson.annotations.SerializedName

data class SecondStage(
    @SerializedName("block")
    val block: Int?,
    @SerializedName("payloads")
    val payloads: List<Payload?>?
)