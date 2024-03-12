package com.magnetwidgets.magnet.extension

import android.graphics.Bitmap
import android.graphics.drawable.Icon
import android.net.Uri

internal fun Array<out Any>.getInt(index: Int = 0, defaultValue: Int = 0): Int {
    return (this.getOrNull(index) as? Int) ?: defaultValue
}

internal fun Array<out Any>.getUri(index: Int = 0, defaultValue: Uri? = null): Uri? {
    return (this.getOrNull(index) as? Uri) ?: defaultValue
}

internal fun Array<out Any>.getIcon(index: Int = 0, defaultValue: Icon? = null): Icon? {
    return (this.getOrNull(index) as? Icon) ?: defaultValue
}

internal fun Array<out Any>.getBitmap(index: Int = 0, defaultValue: Bitmap? = null): Bitmap? {
    return (this.getOrNull(index) as? Bitmap) ?: defaultValue
}