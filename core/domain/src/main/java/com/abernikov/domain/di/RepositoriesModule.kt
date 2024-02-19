package com.abernikov.domain.di

import com.abernikov.domain.SearchRepositories
import com.abernikov.domain.SearchRepositoriesImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
interface RepositoriesModule {
    @Binds
    @Singleton
    fun provideRepository(
        repository: SearchRepositoriesImpl
    ): SearchRepositories


}
