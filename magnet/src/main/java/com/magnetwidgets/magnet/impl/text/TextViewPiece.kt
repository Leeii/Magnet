package com.magnetwidgets.magnet.impl.text

import android.util.TypedValue
import android.view.View
import android.widget.RemoteViews
import android.widget.TextView
import com.magnetwidgets.magnet.Piece
import com.magnetwidgets.magnet.extension.getInt
import com.widgetsmagnet.ksp.MagnetPiece

val textPieces: Array<Piece> = arrayOf(
    TextViewTextPiece(),
    TextColorPiece(),
    TextSizePiece(),
    TextViewCompoundDrawablesPiece(),
    TextViewCompoundDrawablesRelative()
)

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

@MagnetPiece("setTextSize", MagnetPiece.ValueType.Float)
class TextSizePiece : Piece {
    override fun updateView(view: View, vararg values: Any) {
        val size = values.first()
        if (view is TextView && size is Float) {
            view.textSize = size
        }
    }

    override fun updateRemoteView(views: RemoteViews, viewId: Int, vararg values: Any) {
        val size = values.first()
        if (size is Float) {
            views.setTextViewTextSize(viewId, TypedValue.COMPLEX_UNIT_SP, size)
        }
    }
}

@MagnetPiece("setTextViewCompoundDrawables", MagnetPiece.ValueType.Int)
class TextViewCompoundDrawablesPiece : Piece {
    override fun updateView(view: View, vararg values: Any) {
        if (view is TextView) {
            view.setCompoundDrawablesWithIntrinsicBounds(
                values.getInt(0, 0),
                values.getInt(1, 0),
                values.getInt(2, 0),
                values.getInt(3, 0)
            )
        }
    }

    override fun updateRemoteView(views: RemoteViews, viewId: Int, vararg values: Any) {
        views.setTextViewCompoundDrawables(
            viewId,
            values.getInt(0, 0),
            values.getInt(1, 0),
            values.getInt(2, 0),
            values.getInt(3, 0)
        )
    }
}

@MagnetPiece("setTextViewCompoundDrawablesRelative", MagnetPiece.ValueType.Int)
class TextViewCompoundDrawablesRelative : Piece {
    override fun updateView(view: View, vararg values: Any) {
        if (view is TextView) {
            view.setCompoundDrawablesRelativeWithIntrinsicBounds(
                values.getInt(0, 0),
                values.getInt(1, 0),
                values.getInt(2, 0),
                values.getInt(3, 0)
            )
        }
    }

    override fun updateRemoteView(views: RemoteViews, viewId: Int, vararg values: Any) {
        views.setTextViewCompoundDrawablesRelative(
            viewId,
            values.getInt(0, 0),
            values.getInt(1, 0),
            values.getInt(2, 0),
            values.getInt(3, 0)
        )
    }
}
