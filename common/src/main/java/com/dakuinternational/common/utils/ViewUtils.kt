package com.dakuinternational.common.utils

import android.view.View
import android.view.ViewOutlineProvider

fun clipToBackground(view: View) {
    view.outlineProvider = ViewOutlineProvider.BACKGROUND
    view.clipToOutline = true
}