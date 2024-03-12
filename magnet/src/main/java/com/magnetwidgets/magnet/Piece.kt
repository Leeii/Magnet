package com.magnetwidgets.magnet

import android.view.View
import android.widget.RemoteViews

interface Piece {
    fun updateView(view: View, vararg values: Any)

    fun updateRemoteView(views: RemoteViews, viewId: Int, vararg values: Any)
}


fun Piece.illegalArgument(message: String) {
    throw IllegalArgumentException(message)
}