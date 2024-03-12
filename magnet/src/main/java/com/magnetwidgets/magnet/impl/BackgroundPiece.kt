package com.magnetwidgets.magnet.impl

import android.view.View
import android.widget.RemoteViews
import com.magnetwidgets.magnet.Piece
import com.magnetwidgets.magnet.illegalArgument
import com.widgetsmagnet.ksp.MagnetPiece

@MagnetPiece("setBackgroundResource", MagnetPiece.ValueType.Int)
class BackgroundResourcePiece : Piece {
    override fun updateView(view: View, vararg values: Any) {
        val backgroundResource = values.first()
        if (backgroundResource is Int) {
            view.setBackgroundResource(backgroundResource)
        } else {
            illegalArgument("dest is not background resource id.")
        }
    }

    override fun updateRemoteView(views: RemoteViews, viewId: Int, vararg values: Any) {
        val backgroundResource = values.first()
        if (backgroundResource is Int) {
            views.setInt(viewId, "setBackgroundResource", backgroundResource)
        } else {
            illegalArgument("dest is not background resource id.")
        }
    }
}

@MagnetPiece("setBackgroundColor", MagnetPiece.ValueType.Int)
class BackgroundColorPiece : Piece {
    override fun updateView(view: View, vararg values: Any) {
        val backgroundColor = values.first()
        if (backgroundColor is Int) {
            view.setBackgroundColor(backgroundColor)
        } else {
            illegalArgument("dest is not background resource id.")
        }
    }

    override fun updateRemoteView(views: RemoteViews, viewId: Int, vararg values: Any) {
        val backgroundColor = values.first()
        if (backgroundColor is Int) {
            views.setInt(viewId, "setBackgroundColor", backgroundColor)
        } else {
            illegalArgument("dest is not background resource id.")
        }
    }
}

