package com.magnetwidgets.magnet.extension

import android.graphics.Bitmap
import android.graphics.drawable.Icon
import android.net.Uri

internal fun Array<out Any>.getInt(index: Int = 0, defaultValue: Int = 0): Int {
    return (this.getOrNull(index) as? Int) ?: defaultValue
}

internal fun Array<out Any>.getFloat(index: Int = 0, defaultValue: Float = 0f): Float {
    return (this.getOrNull(index) as? Float) ?: defaultValue
}

internal fun Array<out Any>.getBoolean(index: Int = 0, defaultValue: Boolean = false): Boolean {
    return (this.getOrNull(index) as? Boolean) ?: defaultValue
}

internal fun Array<out Any>.getShort(index: Int = 0, defaultValue: Short = 0): Short {
    return (this.getOrNull(index) as? Short) ?: defaultValue
}

internal fun Array<out Any>.getLong(index: Int = 0, defaultValue: Long = 0): Long {
    return (this.getOrNull(index) as? Long) ?: defaultValue
}

internal fun Array<out Any>.getDouble(index: Int = 0, defaultValue: Double = 0.0): Double {
    return (this.getOrNull(index) as? Double) ?: defaultValue
}

internal fun Array<out Any>.getByte(index: Int = 0, defaultValue: Byte = 0): Byte {
    return (this.getOrNull(index) as? Byte) ?: defaultValue
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

internal inline fun <reified T> Array<out Any>.obtain(index: Int = 0, defaultValue: T? = null): T? {
    return (this.getOrNull(index) as? T) ?: defaultValue
}