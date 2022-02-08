package by.maxluxs.crypto2893.di.domain

import by.maxluxs.domain_remote.api.MarketCapApi
import by.maxluxs.domain_repository.repository.RepositoriesFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideRepository(marketCapApi: MarketCapApi) =
        RepositoriesFactory.createCurrencyRepository(marketCapApi)

}