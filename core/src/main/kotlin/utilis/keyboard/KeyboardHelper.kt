package co.th.common.utils.keyboard

import android.view.View
import android.widget.EditText

interface KeyboardHelper {
    fun touchOutHideKeyboard(view: View)
    fun onListenerKeyboard(
        view: View,
        keyboardOpen: () -> Unit,
        keyboardClose: () -> Unit,
    )
    fun isKeyboardOpen(view: View): Boolean
    fun hideKeyboard(view: View)
    fun openKeyboard(view: EditText)
}
