package by.maxluxs.crypto2893.utils

import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.AppBarLayout.LayoutParams.*
import com.google.android.material.appbar.CollapsingToolbarLayout

fun CollapsingToolbarLayout.setToolBarIsScrolling(isOn: Boolean) {
    if (isOn) {
        val toolbar: CollapsingToolbarLayout = this
        val params = toolbar.layoutParams as AppBarLayout.LayoutParams
        params.scrollFlags = 0
        params.scrollFlags = SCROLL_FLAG_SCROLL or SCROLL_FLAG_EXIT_UNTIL_COLLAPSED
    } else {
        val toolbar: CollapsingToolbarLayout = this
        val params = toolbar.layoutParams as AppBarLayout.LayoutParams
        params.scrollFlags = 0
        params.scrollFlags = SCROLL_FLAG_SNAP
    }
}
