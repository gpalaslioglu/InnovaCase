package com.gizempalaslioglu.innovacase.data.repository

import com.gizempalaslioglu.innovacase.data.entity.LaunchesResponseModelItem

interface LaunchesRepository {

    suspend fun getLaunches(): List<LaunchesResponseModelItem>
}
