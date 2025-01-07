package com.gizempalaslioglu.innovacase.di

import com.gizempalaslioglu.innovacase.data.repository.LaunchesRepository
import com.gizempalaslioglu.innovacase.data.repository.LaunchesRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Singleton
    @Binds
    fun bindLaunchesRepository(impl: LaunchesRepositoryImpl): LaunchesRepository
}
