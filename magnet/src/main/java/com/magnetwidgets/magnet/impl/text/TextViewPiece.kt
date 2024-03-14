package com.magnetwidgets.magnet.impl.text

import android.widget.RemoteViews
import android.widget.TextView
import com.magnetwidgets.magnet.BasePiece
import com.magnetwidgets.magnet.Piece
import com.magnetwidgets.magnet.extension.getFloat
import com.magnetwidgets.magnet.extension.getInt
import com.magnetwidgets.magnet.extension.obtain
import com.widgetsmagnet.ksp.MagnetPiece

val textPieces: Array<Piece> = arrayOf(
    TextViewTextPiece(),
    TextColorPiece(),
    TextSizePiece(),
    TextViewCompoundDrawablesPiece(),
    TextViewCompoundDrawablesRelative()
)

@MagnetPiece("setText", [MagnetPiece.ValueType.CharSequence], ["text"])
class TextViewTextPiece : BasePiece<TextView>() {
    override fun updateAppView(view: TextView, vararg values: Any) {
        view.text = values.obtain()
    }

    override fun updateRemoteView(views: RemoteViews, viewId: Int, vararg values: Any) {
        views.setTextViewText(viewId, values.obtain())
    }
}

@MagnetPiece("setTextColor", [MagnetPiece.ValueType.Int], ["color"])
class TextColorPiece : BasePiece<TextView>() {
    override fun updateAppView(view: TextView, vararg values: Any) {
        view.setTextColor(values.obtain() ?: 0)
    }

    override fun updateRemoteView(views: RemoteViews, viewId: Int, vararg values: Any) {
        views.setTextColor(viewId, values.obtain() ?: 0)
    }
}

@MagnetPiece(
    "setTextSize", [MagnetPiece.ValueType.Int, MagnetPiece.ValueType.Float], ["unit", "size"]
)
class TextSizePiece : BasePiece<TextView>() {
    override fun updateAppView(view: TextView, vararg values: Any) {
        view.setTextSize(values.getInt(), values.getFloat(1))
    }

    override fun updateRemoteView(views: RemoteViews, viewId: Int, vararg values: Any) {
        views.setTextViewTextSize(viewId, values.getInt(), values.getFloat(1))
    }
}

@MagnetPiece(
    "setTextViewCompoundDrawables",
    [MagnetPiece.ValueType.Int, MagnetPiece.ValueType.Int, MagnetPiece.ValueType.Int, MagnetPiece.ValueType.Int],
    ["start", "top", "end", "bottom"]
)
class TextViewCompoundDrawablesPiece : BasePiece<TextView>() {

    override fun updateAppView(view: TextView, vararg values: Any) {
        view.setCompoundDrawablesWithIntrinsicBounds(
            values.getInt(0, 0), values.getInt(1, 0), values.getInt(2, 0), values.getInt(3, 0)
        )
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

@MagnetPiece(
    "setTextViewCompoundDrawablesRelative",
    [MagnetPiece.ValueType.Int, MagnetPiece.ValueType.Int, MagnetPiece.ValueType.Int, MagnetPiece.ValueType.Int],
    ["start", "top", "end", "bottom"]
)
class TextViewCompoundDrawablesRelative : BasePiece<TextView>() {
    override fun updateAppView(view: TextView, vararg values: Any) {
        view.setCompoundDrawablesRelativeWithIntrinsicBounds(
            values.getInt(0, 0), values.getInt(1, 0), values.getInt(2, 0), values.getInt(3, 0)
        )
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
