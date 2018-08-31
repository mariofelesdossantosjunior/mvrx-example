package br.com.hussan.mvrx.ui.repositories

import android.support.v4.app.FragmentActivity
import br.com.hussan.mvrx.data.UserRepositoryDataSource
import com.airbnb.mvrx.BaseMvRxViewModel
import com.airbnb.mvrx.MvRxViewModelFactory
import javax.inject.Inject

class UserRepositoriesViewModel
@Inject constructor(initialState: UserRepositoriesState, private var dataSource: UserRepositoryDataSource) :
        BaseMvRxViewModel<UserRepositoriesState>(initialState, true) {

    init {
        logStateChanges()
        getUserRepositories("hussanhijazi")
    }

    fun getUserRepositories(username: String) {
        dataSource.getUserRepositories(username)
                .doOnSubscribe { setState { copy(isLoading = true) } }
                .doOnComplete { setState { copy(isLoading = false) } }
                .execute {
                    copy(repositoriesRequest = it, repositories = it() ?: repositories)
                }
    }

    companion object : MvRxViewModelFactory<UserRepositoriesState> {
        @JvmStatic
        override fun create(activity: FragmentActivity, state: UserRepositoriesState): BaseMvRxViewModel<UserRepositoriesState> {
            // TODO INJECTION
            return (activity as UserRepositoriesActivity).viewModelFactory.create(UserRepositoriesViewModel::class.java)
                    .apply {
                        setState { state }
                    }
        }
    }

}

