package com.magnetwidgets.magnet.extension

internal fun Array<out Any>.getInt(index: Int, defaultValue: Int): Int {
    return (this.getOrNull(index) as? Int) ?: defaultValue
}