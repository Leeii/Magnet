package com.magnetwidgets.magnet

import android.view.View
import android.widget.RemoteViews

interface Piece {
    fun updateView(view: View, vararg values: Any)

    fun updateRemoteView(views: RemoteViews, viewId: Int, vararg values: Any)
}

abstract class BasePiece<T : View> : Piece {
    @Suppress("UNCHECKED_CAST")
    final override fun updateView(view: View, vararg values: Any) {
        (view as? T)?.apply {
            updateAppView(this, *values)
        }
    }

    abstract fun updateAppView(view: T, vararg values: Any)
}

fun Piece.illegalArgument(message: String) {
    throw IllegalArgumentException(message)
}