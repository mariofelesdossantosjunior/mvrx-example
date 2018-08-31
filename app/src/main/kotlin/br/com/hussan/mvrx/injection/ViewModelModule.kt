package br.com.hussan.mvrx.injection

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import br.com.hussan.mvrx.ui.repositories.UserRepositoriesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(UserRepositoriesViewModel::class)
    abstract fun bindUserRepositoriesViewModel(mainViewModel: UserRepositoriesViewModel): ViewModel

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
