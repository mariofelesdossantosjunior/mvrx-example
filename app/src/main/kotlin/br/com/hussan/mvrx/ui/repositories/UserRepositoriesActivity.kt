package br.com.hussan.mvrx.ui.repositories

import android.arch.lifecycle.ViewModelProvider
import android.os.Bundle
import br.com.hussan.mvrx.R
import br.com.hussan.mvrx.injection.Injectable
import com.airbnb.mvrx.BaseMvRxActivity
import dagger.android.AndroidInjection
import javax.inject.Inject

class UserRepositoriesActivity : BaseMvRxActivity(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repositories)

        AndroidInjection.inject(this)

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val fragment = UserRepositoriesFragment()
        fragmentTransaction.add(R.id.container, fragment)
        fragmentTransaction.commit()
    }

}
