package by.maxluxs.crypto2893.di.features

import by.maxluxs.crypto2893.di.AppModule
import by.maxluxs.crypto2893.di.app.ViewModelKey
import by.maxluxs.feature_currency_list.CurrencyListFragment
import by.maxluxs.feature_currency_list.CurrencyListViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
internal abstract class CurrencyListFeatureModule {
    @ContributesAndroidInjector(modules = [AppModule::class])
    abstract fun provideMainFragment(): CurrencyListFragment

    // добавить
    @Binds
    @IntoMap
    @ViewModelKey(CurrencyListViewModel::class)
    internal abstract fun bindMainViewModel(viewModel: CurrencyListViewModel): CurrencyListViewModel
}