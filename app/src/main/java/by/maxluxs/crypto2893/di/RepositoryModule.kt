package by.maxluxs.crypto2893.di

import by.maxluxs.domain_remote.api.MarketCapApi
import by.maxluxs.domain_repository.RepositoriesFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideRepository(marketCapApi: MarketCapApi) =
        RepositoriesFactory.createCurrencyRepository(marketCapApi)

}