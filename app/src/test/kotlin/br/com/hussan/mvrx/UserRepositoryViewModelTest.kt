package br.com.hussan.mvrx

import br.com.hussan.mvrx.data.UserRepositoryDataSource
import br.com.hussan.mvrx.data.model.UserRepository
import br.com.hussan.mvrx.ui.repositories.UserRepositoriesState
import br.com.hussan.mvrx.ui.repositories.UserRepositoriesViewModel
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.`when`

@Suppress("IllegalIdentifier")
class UserRepositoryViewModelTest {

    lateinit var dataSource: UserRepositoryDataSource
    lateinit var viewModel: UserRepositoriesViewModel

    @Before
    fun setUp() {

        dataSource = mock()
        viewModel = UserRepositoriesViewModel(UserRepositoriesState(), dataSource)

    }

    @Test
    fun `get github username`() {
        val login = "login"

        val repositories = listOf(UserRepository())

        `when`(dataSource.getUserRepositories(login)).thenReturn(Observable.just(repositories))
        
    }

}
