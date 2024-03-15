package com.magnetwidgets.magnet.impl

import android.os.Build
import android.view.View
import android.widget.RemoteViews
import com.magnetwidgets.magnet.Piece
import com.magnetwidgets.magnet.extension.getInt
import com.magnetwidgets.magnet.extension.obtain
import com.widgetsmagnet.ksp.MagnetPiece

val backgroundPieces = arrayOf(
    BackgroundResourcePiece(),
    BackgroundColorPiece(),
    BackgroundTintListPiece(),
    BackgroundTintBlendModePiece()
)

@MagnetPiece("setBackgroundResource", [MagnetPiece.ValueType.Int], ["id"])
class BackgroundResourcePiece : Piece {
    override fun updateView(view: View, vararg values: Any) {
        view.setBackgroundResource(values.getInt())
    }

    override fun updateRemoteView(views: RemoteViews, viewId: Int, vararg values: Any) {
        views.setInt(viewId, "setBackgroundResource", values.getInt())
    }
}

@MagnetPiece("setBackgroundColor", [MagnetPiece.ValueType.Int], ["color"])
class BackgroundColorPiece : Piece {
    override fun updateView(view: View, vararg values: Any) {
        view.setBackgroundColor(values.getInt())
    }

    override fun updateRemoteView(views: RemoteViews, viewId: Int, vararg values: Any) {
        views.setInt(viewId, "setBackgroundColor", values.getInt())
    }
}

// setBackgroundTintList
@MagnetPiece("setBackgroundTintList", [MagnetPiece.ValueType.ColorStateList], ["tint"])
class BackgroundTintListPiece : Piece {
    override fun updateView(view: View, vararg values: Any) {
        view.backgroundTintList = values.obtain()
    }

    override fun updateRemoteView(views: RemoteViews, viewId: Int, vararg values: Any) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            views.setColorStateList(viewId, "setBackgroundTintList", values.obtain())
        }
    }
}

// setBackgroundTintBlendMode
@MagnetPiece("setBackgroundTintBlendMode", [MagnetPiece.ValueType.Int], ["blendMode"])
class BackgroundTintBlendModePiece : Piece {
    override fun updateView(view: View, vararg values: Any) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            view.backgroundTintBlendMode = values.obtain()
        }
    }

    override fun updateRemoteView(views: RemoteViews, viewId: Int, vararg values: Any) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            views.setBlendMode(viewId, "setBackgroundTintBlendMode", values.obtain())
        }
    }
}