package utilis.keyboard

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Rect
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import co.th.common.utils.keyboard.KeyboardHelper

class KeyboardHelperImpl() : KeyboardHelper {

    private var isKeyBroadOpen = false

    @SuppressLint("ClickableViewAccessibility")
    override fun touchOutHideKeyboard(view: View) {
        if (view !is AppCompatEditText && view !is AppCompatButton) {
            view.setOnTouchListener { _, event ->
                when (event.action) {
                    MotionEvent.ACTION_DOWN, MotionEvent.ACTION_UP -> {
                        hideKeyboard(view)
                    }
                }
                true
            }
        }
    }

    override fun onListenerKeyboard(
        view: View,
        keyboardOpen: () -> Unit,
        keyboardClose: () -> Unit,
    ) {
        view.viewTreeObserver?.addOnGlobalLayoutListener {
            view.let { view ->
                val rect = Rect()
                view.getWindowVisibleDisplayFrame(rect)
                val heightDiff: Int = view.rootView.height - rect.height()
                if (heightDiff > 0.25 * view.rootView.height) {
                    if (!isKeyBroadOpen) {
                        isKeyBroadOpen = true
                        keyboardOpen()
                    }
                } else {
                    if (isKeyBroadOpen) {
                        isKeyBroadOpen = false
                        keyboardClose()
                    }
                }
            }
        }
    }

    override fun isKeyboardOpen(view: View,): Boolean {
        val rect = Rect()
        view.getWindowVisibleDisplayFrame(rect)
        val heightDiff: Int = view.rootView.height - rect.height()
        return heightDiff > 0.25 * view.rootView.height
    }

    override fun hideKeyboard(view: View) {
        val imm = view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    override fun openKeyboard(view: EditText) {
        view.requestFocus()
        val imm = view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
    }
}
