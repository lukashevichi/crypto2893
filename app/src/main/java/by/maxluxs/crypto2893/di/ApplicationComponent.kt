package by.maxluxs.crypto2893.di

import by.maxluxs.crypto2893.di.app.AppModule
import by.maxluxs.crypto2893.di.features.CurrencyListFeatureModule
import by.maxluxs.crypto2893.ui.main.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        RemoteModule::class,
        RepositoryModule::class,
        CurrencyListFeatureModule::class,
    ]
)
interface ApplicationComponent {
    fun inject(activity: MainActivity)
}