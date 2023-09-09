package nav_option

import androidx.navigation.NavOptions
import navigation.R

object NavigateOption {
    val fromRight by lazy {
        NavOptions.Builder()
            .setEnterAnim(R.anim.from_right)
            .setExitAnim(R.anim.to_left)
            .setPopEnterAnim(R.anim.from_left)
            .setPopExitAnim(R.anim.to_right)
            .build()
    }

    val fromBottom by lazy {
        NavOptions.Builder()
            .setEnterAnim(R.anim.nav_slide_up)
            .setExitAnim(R.anim.nav_stationary)
            .setPopEnterAnim(R.anim.nav_stationary)
            .setPopExitAnim(R.anim.nav_slide_down)
            .build()
    }
}