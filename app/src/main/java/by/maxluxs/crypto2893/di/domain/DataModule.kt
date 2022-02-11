package by.maxluxs.crypto2893.di.domain

import by.maxluxs.crypto2893.domain.repositories.CurrenciesRepository
import by.maxluxs.data.network.coin_market_cap.api.MarketCapApi
import by.maxluxs.data.network.coin_market_cap.api.factory.MarketCapApiFactory
import by.maxluxs.data.repositories.currency_repository.repository.RepositoriesFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Singleton
    @Provides
    fun provideMarketCapApi(): MarketCapApi = MarketCapApiFactory.create()

    @Singleton
    @Provides
    fun provideRepository(marketCapApi: MarketCapApi): CurrenciesRepository =
        RepositoriesFactory.createCurrencyRepository(marketCapApi)

}