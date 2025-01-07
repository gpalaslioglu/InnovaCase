package com.gizempalaslioglu.innovacase.data.api

import com.gizempalaslioglu.innovacase.data.entity.LaunchesResponseModelItem
import retrofit2.Response
import retrofit2.http.GET

interface SpaceXApi {

    @GET("launches")
    suspend fun getLaunches(): Response<List<LaunchesResponseModelItem>>
}
