package com.gizempalaslioglu.innovacase.domain.usecase

import com.gizempalaslioglu.innovacase.data.repository.LaunchesRepository
import com.gizempalaslioglu.innovacase.domain.model.LaunchListUIModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetLaunchListUseCase @Inject constructor(
    private val repository: LaunchesRepository,
    private val mapper: GetLaunchListUIModelMapper
) {

    suspend operator fun invoke(): LaunchListUIModel {
        val response = withContext(Dispatchers.IO) {
            repository.getLaunches()
        }

        return mapper.map(response)
    }
}
