package com.gizempalaslioglu.innovacase.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class LaunchItemDomainModel(
    val id: String?,
    val name: String?,
    val launchYear: String?,
    val flightNumber: Int?,
    val lastLaunchDate: String?,
    val success: Boolean?,
    val details: String?,
    val image: String?,
    val imageSmall: String?
) : Parcelable
