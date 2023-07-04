package com.robertoazeredo.punkbeer.di

import com.robertoazeredo.punkbeer.data.repository.BeersRepository
import com.robertoazeredo.punkbeer.data.repository.BeersRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface RepositoryModule {

    @Binds
    fun bindBeersRepository(beersRepository: BeersRepositoryImpl): BeersRepository
}