package br.com.hussan.mvrx.ui.repositories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.hussan.mvrx.R
import br.com.hussan.mvrx.injection.Injectable
import br.com.hussan.mvrx.views.horizontalLoadingView
import com.airbnb.mvrx.BaseMvRxFragment
import com.airbnb.mvrx.fragmentViewModel
import kotlinx.android.synthetic.main.fragment_repositories.rvList

class UserRepositoriesFragment : BaseMvRxFragment() {

    private val viewModel: UserRepositoriesViewModel by fragmentViewModel()
    private val epoxyController by lazy { epoxyController() }

    override fun invalidate() {
        rvList.requestModelBuild()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_repositories, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvList.setController(epoxyController)
    }

    private fun epoxyController() = simpleController(viewModel) { state ->
        horizontalLoadingView {
            id("loader")
            loading(state.isLoading)
        }
        state.repositories
                .forEach { repository ->
                    userRepositoryItemView {
                        id(repository.id)
                        title(repository.name.toString())
                    }
                }
    }
}
