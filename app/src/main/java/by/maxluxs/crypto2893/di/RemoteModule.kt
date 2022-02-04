package by.maxluxs.crypto2893.di

import by.maxluxs.domain_remote.api.MarketCapApi
import by.maxluxs.domain_remote.api.MarketCapApiFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteModule {

    @Singleton
    @Provides
    fun provideMarketCapApi(): MarketCapApi = MarketCapApiFactory.createMarketCapApi()

}