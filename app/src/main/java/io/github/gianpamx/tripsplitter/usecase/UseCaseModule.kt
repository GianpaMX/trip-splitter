package io.github.gianpamx.tripsplitter.usecase

import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {
    @Provides
    fun provideGetAllTripsUseCase() = GetAllTripsUseCase()
}
