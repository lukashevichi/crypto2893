package by.maxluxs.crypto2893.di.domain

import by.maxluxs.domain_remote.api.MarketCapApi
import by.maxluxs.domain_remote.api.MarketCapApiFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteModule {

    @Singleton
    @Provides
    fun provideMarketCapApi(): MarketCapApi = MarketCapApiFactory.createMarketCapApi()

}