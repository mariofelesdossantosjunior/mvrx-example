package br.com.hussan.mvrx.data

import br.com.hussan.mvrx.data.model.UserRepository
import br.com.hussan.mvrx.data.remote.AppApi
import io.reactivex.Observable

interface UserRepositoryDataSource {
    fun getUserRepositories(username: String): Observable<List<UserRepository>>
}

class UserRepositoryRepository(private val appApi: AppApi) : UserRepositoryDataSource {
    override fun getUserRepositories(username: String): Observable<List<UserRepository>> {
        return appApi.getUserRepositories(username)
    }

}
