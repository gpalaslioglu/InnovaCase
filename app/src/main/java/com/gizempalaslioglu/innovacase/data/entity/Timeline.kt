package com.gizempalaslioglu.innovacase.data.entity

import com.google.gson.annotations.SerializedName

data class Timeline(
    @SerializedName("beco")
    val beco: Int?,
    @SerializedName("center_core_boostback")
    val centerCoreBoostback: Int?,
    @SerializedName("center_core_entry_burn")
    val centerCoreEntryBurn: Int?,
    @SerializedName("center_core_landing")
    val centerCoreLanding: Int?,
    @SerializedName("center_stage_sep")
    val centerStageSep: Int?,
    @SerializedName("dragon_bay_door_deploy")
    val dragonBayDoorDeploy: Int?,
    @SerializedName("dragon_separation")
    val dragonSeparation: Int?,
    @SerializedName("dragon_solar_deploy")
    val dragonSolarDeploy: Int?,
    @SerializedName("engine_chill")
    val engineChill: Int?,
    @SerializedName("fairing_deploy")
    val fairingDeploy: Int?,
    @SerializedName("first_stage_boostback_burn")
    val firstStageBoostbackBurn: Int?,
    @SerializedName("first_stage_entry_burn")
    val firstStageEntryBurn: Int?,
    @SerializedName("first_stage_landing")
    val firstStageLanding: Int?,
    @SerializedName("first_stage_landing_burn")
    val firstStageLandingBurn: Int?,
    @SerializedName("go_for_launch")
    val goForLaunch: Int?,
    @SerializedName("go_for_prop_loading")
    val goForPropLoading: Int?,
    @SerializedName("ignition")
    val ignition: Int?,
    @SerializedName("liftoff")
    val liftoff: Int?,
    @SerializedName("maxq")
    val maxq: Int?,
    @SerializedName("meco")
    val meco: Int?,
    @SerializedName("payload_deploy")
    val payloadDeploy: Int?,
    @SerializedName("payload_deploy_1")
    val payloadDeploy1: Int?,
    @SerializedName("payload_deploy_2")
    val payloadDeploy2: Int?,
    @SerializedName("prelaunch_checks")
    val prelaunchChecks: Int?,
    @SerializedName("propellant_pressurization")
    val propellantPressurization: Int?,
    @SerializedName("rp1_loading")
    val rp1Loading: Int?,
    @SerializedName("seco-1")
    val seco1: Int?,
    @SerializedName("seco-2")
    val seco2: Int?,
    @SerializedName("seco-3")
    val seco3: Int?,
    @SerializedName("seco-4")
    val seco4: Int?,
    @SerializedName("second_stage_restart")
    val secondStageRestart: Int?,
    @SerializedName("second_stage_ignition")
    val secondStageİgnition: Int?,
    @SerializedName("side_core_boostback")
    val sideCoreBoostback: Int?,
    @SerializedName("side_core_entry_burn")
    val sideCoreEntryBurn: Int?,
    @SerializedName("side_core_landing")
    val sideCoreLanding: Int?,
    @SerializedName("side_core_sep")
    val sideCoreSep: Int?,
    @SerializedName("stage1_lox_loading")
    val stage1LoxLoading: Int?,
    @SerializedName("stage1_rp1_loading")
    val stage1Rp1Loading: Int?,
    @SerializedName("stage2_lox_loading")
    val stage2LoxLoading: Int?,
    @SerializedName("stage2_rp1_loading")
    val stage2Rp1Loading: Int?,
    @SerializedName("stage_sep")
    val stageSep: Int?,
    @SerializedName("webcast_launch")
    val webcastLaunch: Int?,
    @SerializedName("webcast_liftoff")
    val webcastLiftoff: Int?
)