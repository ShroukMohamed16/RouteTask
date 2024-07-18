package com.example.routetask.di


import com.example.data.remote.ApiService
import com.example.data.repository.MainRepositoryImp
import com.example.domain.repository.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    @Singleton
    fun provideMainRepo(
        apiService: ApiService
    ):
            MainRepository =
        MainRepositoryImp(
            apiService,

        )





}