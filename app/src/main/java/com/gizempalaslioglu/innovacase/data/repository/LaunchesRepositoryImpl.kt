package com.gizempalaslioglu.innovacase.data.repository

import com.gizempalaslioglu.innovacase.core.networkCall
import com.gizempalaslioglu.innovacase.data.api.SpaceXApi
import com.gizempalaslioglu.innovacase.data.entity.LaunchesResponseModelItem
import javax.inject.Inject

class LaunchesRepositoryImpl @Inject constructor(
    private val api: SpaceXApi
) : LaunchesRepository {

    override suspend fun getLaunches(): List<LaunchesResponseModelItem> {
        return networkCall { api.getLaunches() }
    }
}
