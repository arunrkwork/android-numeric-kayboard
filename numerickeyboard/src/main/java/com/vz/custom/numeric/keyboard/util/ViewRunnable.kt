package com.vz.custom.numeric.keyboard.util

import android.view.View

internal abstract class ViewRunnable : Runnable {
    var view: View? = null
}