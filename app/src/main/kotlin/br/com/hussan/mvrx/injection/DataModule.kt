package br.com.hussan.mvrx.injection

import br.com.hussan.mvrx.data.UserRepositoryDataSource
import br.com.hussan.mvrx.data.UserRepositoryRepository
import br.com.hussan.mvrx.data.remote.AppApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

    @Provides
    @Singleton
    fun providesUserRespositoryDataSource(appApi: AppApi): UserRepositoryDataSource =
            UserRepositoryRepository(appApi)

}
