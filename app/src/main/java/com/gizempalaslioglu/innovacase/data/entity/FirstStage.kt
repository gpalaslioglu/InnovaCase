package com.gizempalaslioglu.innovacase.data.entity

import com.google.gson.annotations.SerializedName

data class FirstStage(
    @SerializedName("cores")
    val cores: List<Core?>?
)