package com.vz.custom.numeric.keyboard.listeners

import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.vz.custom.numeric.keyboard.view.IconifiedTextView
import kotlin.math.min


internal class KeyClickListener(
    private val field: EditText?,
    private val maxLength: Int
) : View.OnClickListener {
    override fun onClick(view: View?) {
        val field = this.field ?: return

        if (view is IconifiedTextView) {
            field.removeCharBeforeSelection()
        } else if (view is TextView) {
            val newChar = view.text[0]
            field.addCharAfterSelection(newChar)
        }
    }

    private fun EditText.addCharAfterSelection(newChar: Char) {
        if (isBiggerThanMaxLength(text)) {
            return
        }

        val selectionEnd = this.selectionEnd
        val newTextBuilder = StringBuilder()
            .append(text.subSequence(0, selectionEnd))
            .append(newChar)
            .append(text.subSequence(selectionEnd, length()))

        setText(newTextBuilder)
        setSelectionWithValidation(selectionEnd + 1) // set selection to the next character
    }

    private fun isBiggerThanMaxLength(
        text: CharSequence
    ) = maxLength > 0 && text.length >= maxLength

    private fun EditText.removeCharBeforeSelection() {
        val removableCharPosition = selectionEnd - 1
        if (removableCharPosition < 0) {
            return // do nothing if there are no characters before the cursor
        }

        val newTextBuilder = StringBuilder()
            .append(text.substring(0, removableCharPosition))
            .append(text.substring(removableCharPosition + 1))

        setText(newTextBuilder)
        setSelectionWithValidation(removableCharPosition)
    }

    private fun EditText.setSelectionWithValidation(index: Int) {
        setSelection(min(index, text.length))
    }
}