package br.com.hussan.mvrx.data.remote

import br.com.hussan.mvrx.data.model.UserRepository
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * REST API access points
 */
interface AppApi {
    @GET("users/{username}/repos")
    fun getUserRepositories(@Path("username") username: String): Observable<List<UserRepository>>

}
