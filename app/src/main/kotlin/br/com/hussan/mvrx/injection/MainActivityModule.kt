package br.com.hussan.mvrx.injection

import br.com.hussan.mvrx.ui.repositories.UserRepositoriesActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {
    @ContributesAndroidInjector
    internal abstract fun contributeMainActivity(): UserRepositoriesActivity

}
