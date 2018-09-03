package br.com.hussan.mvrx.injection

import android.content.Context
import br.com.hussan.mvrx.BuildConfig
import br.com.hussan.mvrx.data.remote.AppApi
import br.com.hussan.mvrx.ui.repositories.UserRepositoriesState
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
open class ApiModule {

    open fun getOkHttpBuilder(): OkHttpClient.Builder = OkHttpClient.Builder()

    @Provides
    @Singleton
    fun providesOkHttpClient(@Named("ApplicationContext") context: Context): OkHttpClient {
        return getOkHttpBuilder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .addInterceptor { chain ->
                    val original = chain.request()

                    val requestBuilder = original.newBuilder()

                    // Store token if needed in sharedPreferences

                    val response = chain.proceed(requestBuilder.method(original.method(), original.body()).build())

                    response
                }
                .build()
    }

    @Provides
    @Singleton
    fun providesAppApi(okHttpClient: OkHttpClient): AppApi {
        val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BuildConfig.API_URL)
                .client(okHttpClient)
                .build()

        return retrofit.create(AppApi::class.java)
    }

    @Provides
    @Singleton
    fun providesGson(): Gson = GsonBuilder().create()
    
}
