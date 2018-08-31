package br.com.hussan.mvrx.ui.repositories

import com.airbnb.epoxy.AsyncEpoxyController
import com.airbnb.epoxy.EpoxyController
import com.airbnb.mvrx.BaseMvRxViewModel
import com.airbnb.mvrx.MvRxState

class UserRepositoryEpoxyController(
        val buildModelsCallback: EpoxyController.() -> Unit = {}
) : AsyncEpoxyController() {
    override fun buildModels() {
        buildModelsCallback()
    }
}

/**
 * Create a [UserRepositoryEpoxyController] that builds models with the given callback.
 * When models are built the current state of the viewmodel will be provided.
 */
fun <S : MvRxState, A : BaseMvRxViewModel<S>> simpleController(
        viewModel: A,
        buildModels: EpoxyController.(state: S) -> Unit
) = UserRepositoryEpoxyController {
    com.airbnb.mvrx.withState(viewModel) { state ->
        buildModels(state)
    }
}

