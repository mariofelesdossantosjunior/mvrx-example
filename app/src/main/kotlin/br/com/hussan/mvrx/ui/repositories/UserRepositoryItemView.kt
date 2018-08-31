package br.com.hussan.mvrx.ui.repositories

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import br.com.hussan.mvrx.R
import com.airbnb.epoxy.ModelView
import com.airbnb.epoxy.TextProp
import kotlinx.android.synthetic.main.repository_item.view.txtName

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class UserRepositoryItemView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    init {
        inflate(context, R.layout.repository_item, this)
    }

    @TextProp
    fun setTitle(title: CharSequence) {
        txtName.text = title
    }
}
