package com.magnetwidgets.magnet.impl.text

import android.view.View
import android.widget.RemoteViews
import android.widget.TextView
import com.magnetwidgets.magnet.Piece
import com.widgetsmagnet.ksp.MagnetPiece

@MagnetPiece("setText", MagnetPiece.ValueType.CharSequence)
class TextViewTextPiece : Piece {
    override fun updateView(view: View, vararg values: Any) {
        val text = values.first()
        if (view is TextView && text is CharSequence) {
            view.text = text
        }
    }

    override fun updateRemoteView(views: RemoteViews, viewId: Int, vararg values: Any) {
        val text = values.first()
        if (text is CharSequence) {
            views.setTextViewText(viewId, text)
        }
    }
}

@MagnetPiece("setTextColor", MagnetPiece.ValueType.Int)
class TextColorPiece : Piece {
    override fun updateView(view: View, vararg values: Any) {
        val color = values.first()
        if (view is TextView && color is Int) {
            view.setTextColor(color)
        }
    }

    override fun updateRemoteView(views: RemoteViews, viewId: Int, vararg values: Any) {
        val color = values.first()
        if (color is Int) {
            views.setTextColor(viewId, color)
        }
    }
}