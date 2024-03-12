package com.magnetwidgets.magnet.impl

import android.view.View
import android.widget.RemoteViews
import com.magnetwidgets.magnet.Piece
import com.magnetwidgets.magnet.extension.getInt
import com.widgetsmagnet.ksp.MagnetPiece

@MagnetPiece("setBackgroundResource", MagnetPiece.ValueType.Int)
class BackgroundResourcePiece : Piece {
    override fun updateView(view: View, vararg values: Any) {
        view.setBackgroundResource(values.getInt())
    }

    override fun updateRemoteView(views: RemoteViews, viewId: Int, vararg values: Any) {
        views.setInt(viewId, "setBackgroundResource", values.getInt())
    }
}

@MagnetPiece("setBackgroundColor", MagnetPiece.ValueType.Int)
class BackgroundColorPiece : Piece {
    override fun updateView(view: View, vararg values: Any) {
        view.setBackgroundColor(values.getInt())
    }

    override fun updateRemoteView(views: RemoteViews, viewId: Int, vararg values: Any) {
        views.setInt(viewId, "setBackgroundColor", values.getInt())
    }
}

