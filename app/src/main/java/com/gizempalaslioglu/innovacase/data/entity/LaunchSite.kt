package com.gizempalaslioglu.innovacase.data.entity

import com.google.gson.annotations.SerializedName

data class LaunchSite(
    @SerializedName("site_name")
    val siteName: String?,
    @SerializedName("site_name_long")
    val siteNameLong: String?,
    @SerializedName("site_id")
    val siteId: String?
)