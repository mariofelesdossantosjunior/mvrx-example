package br.com.hussan.mvrx.ui.repositories

import br.com.hussan.mvrx.data.model.UserRepository
import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.Uninitialized

data class UserRepositoriesState(
        val repositories: List<UserRepository> = emptyList(),
        val repositoriesRequest: Async<List<UserRepository>> = Uninitialized,
        val isLoading: Boolean = false) : MvRxState
