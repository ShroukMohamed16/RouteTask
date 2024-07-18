package com.example.routetask.di

import com.example.domain.repository.MainRepository
import com.example.domain.use_cases.MainUseCasee
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideMainUseCase(mainRepository: MainRepository): MainUseCasee {
        return MainUseCasee(
           mainRepository
        )
    }


}








