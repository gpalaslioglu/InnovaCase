package com.gizempalaslioglu.innovacase.domain.usecase

import com.gizempalaslioglu.innovacase.core.Mapper
import com.gizempalaslioglu.innovacase.data.entity.LaunchesResponseModelItem
import com.gizempalaslioglu.innovacase.domain.model.LaunchItemDomainModel
import com.gizempalaslioglu.innovacase.domain.model.LaunchListUIModel
import javax.inject.Inject

class GetLaunchListUIModelMapper @Inject constructor() :
    Mapper<List<LaunchesResponseModelItem>, LaunchListUIModel> {

    override fun map(input: List<LaunchesResponseModelItem>): LaunchListUIModel {
        val years = input
            .mapNotNull { it.launchYear }
            .distinct()
        val launches = input.mapToLaunchItemDomainModel()

        return LaunchListUIModel(years, launches)
    }

    private fun List<LaunchesResponseModelItem>.mapToLaunchItemDomainModel(): List<LaunchItemDomainModel> {
        return map {
            LaunchItemDomainModel(
                id = it.missionId?.firstOrNull(),
                name = it.missionName,
                launchYear = it.launchYear,
                flightNumber = it.flightNumber,
                lastLaunchDate = it.lastLlLaunchDate,
                success = it.launchSuccess,
                details = it.details,
                image = it.links?.missionPatch,
                imageSmall = it.links?.missionPatchSmall
            )
        }
    }
}
