package br.com.hussan.mvrx.injection

import android.app.Application
import android.content.Context
import br.com.hussan.mvrx.AppApplication
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module(includes = arrayOf(ViewModelModule::class))
class AppModule {

    @Provides
    @Singleton
    @Named("ApplicationContext")
    fun providesApplicationContext(application: Application): Context = application

    @Provides
    @Singleton
    fun providesApplication(application: AppApplication): AppApplication = application

}
