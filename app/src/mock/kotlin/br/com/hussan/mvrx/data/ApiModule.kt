package br.com.hussan.mvrx.data

import br.com.hussan.mvrx.data.remote.FakeAppApi
import br.com.hussan.mvrx.data.remote.AppApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
open class ApiModule {

    @Provides
    @Singleton
    fun providesAppApi(): AppApi = FakeAppApi()


    open fun getOkHttpBuilder(): OkHttpClient.Builder {
        throw UnsupportedOperationException()
    }
}
