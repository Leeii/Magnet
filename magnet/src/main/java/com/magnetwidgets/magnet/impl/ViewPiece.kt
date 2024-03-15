package com.magnetwidgets.magnet.impl

import android.os.Build
import android.view.View
import android.widget.RemoteViews
import com.magnetwidgets.magnet.Piece
import com.magnetwidgets.magnet.extension.getBoolean
import com.magnetwidgets.magnet.extension.getFloat
import com.magnetwidgets.magnet.extension.getInt
import com.magnetwidgets.magnet.extension.obtain
import com.widgetsmagnet.ksp.MagnetPiece

val viewPieces: Array<Piece> = arrayOf(
    ScrollIndicatorsPiece(),
    StateDescriptionPiece(),
    ContentDescriptionPiece(),
    AccessibilityTraversalBeforePiece(),
    AccessibilityTraversalAfterPiece(),
    LabelForPiece(),
    VisibilityPiece(),
    EnabledPiece(),
    FocusablePiece(),
    FocusableIntPiece(),
    FocusableInTouchModePiece(),
    LayoutDirectionPiece(),
    FocusedByDefaultPiece(),
    RotationPiece(),
    RotationYPiece(),
    RotationXPiece(),
    ScaleXPiece(),
    ScaleYPiece(),
    PivotXPiece(),
    PivotYPiece(),
    AlphaPiece(),
    ElevationPiece(),
    TranslationXPiece(),
    TranslationYPiece(),
    TranslationZPiece(),
    ClipToOutlinePiece(),
    ForegroundTintListPiece(),
    ForegroundTintBlendModePiece(),
    MinimumHeightPiece(),
    MinimumWidthPiece()
)

// setScrollIndicators
@MagnetPiece("setScrollIndicators", [MagnetPiece.ValueType.Int], ["indicators"])
class ScrollIndicatorsPiece : Piece {
    override fun updateView(view: View, vararg values: Any) {
        view.scrollIndicators = values.getInt()
    }

    override fun updateRemoteView(views: RemoteViews, viewId: Int, vararg values: Any) {
        views.setInt(viewId, "setScrollIndicators", values.getInt())
    }
}

// setStateDescription
@MagnetPiece("setStateDescription", [MagnetPiece.ValueType.CharSequence], ["stateDescription"])
class StateDescriptionPiece : Piece {
    override fun updateView(view: View, vararg values: Any) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            view.stateDescription = values.obtain()
        }
    }

    override fun updateRemoteView(views: RemoteViews, viewId: Int, vararg values: Any) {
        views.setCharSequence(viewId, "setStateDescription", values.obtain())
    }
}

// setContentDescription
@MagnetPiece("setContentDescription", [MagnetPiece.ValueType.CharSequence], ["contentDescription"])
class ContentDescriptionPiece : Piece {
    override fun updateView(view: View, vararg values: Any) {
        view.contentDescription = values.obtain()
    }

    override fun updateRemoteView(views: RemoteViews, viewId: Int, vararg values: Any) {
        views.setContentDescription(viewId, values.obtain())
    }
}

// setAccessibilityTraversalBefore
@MagnetPiece("setAccessibilityTraversalBefore", [MagnetPiece.ValueType.Int], ["beforeId"])
class AccessibilityTraversalBeforePiece : Piece {
    override fun updateView(view: View, vararg values: Any) {
        view.accessibilityTraversalBefore = values.getInt()
    }

    override fun updateRemoteView(views: RemoteViews, viewId: Int, vararg values: Any) {
        views.setAccessibilityTraversalBefore(viewId, values.getInt())
    }
}

// setAccessibilityTraversalAfter
@MagnetPiece("setAccessibilityTraversalAfter", [MagnetPiece.ValueType.Int], ["afterId"])
class AccessibilityTraversalAfterPiece : Piece {
    override fun updateView(view: View, vararg values: Any) {
        view.accessibilityTraversalAfter = values.getInt()
    }

    override fun updateRemoteView(views: RemoteViews, viewId: Int, vararg values: Any) {
        views.setAccessibilityTraversalAfter(viewId, values.getInt())
    }
}

// setLabelFor
@MagnetPiece("setLabelFor", [MagnetPiece.ValueType.Int], ["id"])
class LabelForPiece : Piece {
    override fun updateView(view: View, vararg values: Any) {
        view.labelFor = values.getInt()
    }

    override fun updateRemoteView(views: RemoteViews, viewId: Int, vararg values: Any) {
        views.setLabelFor(viewId, values.getInt())
    }
}

// setVisibility
@MagnetPiece("setVisibility", [MagnetPiece.ValueType.Int], ["visibility"])
class VisibilityPiece : Piece {
    override fun updateView(view: View, vararg values: Any) {
        view.visibility = values.getInt()
    }

    override fun updateRemoteView(views: RemoteViews, viewId: Int, vararg values: Any) {
        views.setViewVisibility(viewId, values.getInt())
    }
}

// setEnabled
@MagnetPiece("setEnabled", [MagnetPiece.ValueType.Boolean], ["enabled"])
class EnabledPiece : Piece {
    override fun updateView(view: View, vararg values: Any) {
        view.isEnabled = values.getBoolean()
    }

    override fun updateRemoteView(views: RemoteViews, viewId: Int, vararg values: Any) {
        views.setBoolean(viewId, "setEnabled", values.getBoolean())
    }
}

// setFocusable
@MagnetPiece("setFocusable", [MagnetPiece.ValueType.Boolean], ["focusable"])
class FocusablePiece : Piece {
    override fun updateView(view: View, vararg values: Any) {
        view.isFocusable = values.getBoolean()
    }

    override fun updateRemoteView(views: RemoteViews, viewId: Int, vararg values: Any) {
        views.setBoolean(viewId, "setFocusable", values.getBoolean())
    }
}

// setFocusable 2
@MagnetPiece("setFocusable", [MagnetPiece.ValueType.Int], ["focusable"])
class FocusableIntPiece : Piece {
    override fun updateView(view: View, vararg values: Any) {
        view.focusable = values.getInt(defaultValue = View.FOCUSABLE_AUTO)
    }

    override fun updateRemoteView(views: RemoteViews, viewId: Int, vararg values: Any) {
        views.setInt(viewId, "setFocusable", values.getInt(defaultValue = View.FOCUSABLE_AUTO))
    }
}

//setFocusableInTouchMode
@MagnetPiece("setFocusableInTouchMode", [MagnetPiece.ValueType.Boolean], ["focusableInTouchMode"])
class FocusableInTouchModePiece : Piece {
    override fun updateView(view: View, vararg values: Any) {
        view.isFocusableInTouchMode = values.getBoolean()
    }

    override fun updateRemoteView(views: RemoteViews, viewId: Int, vararg values: Any) {
        views.setBoolean(viewId, "setFocusableInTouchMode", values.getBoolean())
    }
}

// setLayoutDirection
@MagnetPiece("setLayoutDirection", [MagnetPiece.ValueType.Int], ["layoutDirection"])
class LayoutDirectionPiece : Piece {
    override fun updateView(view: View, vararg values: Any) {
        view.layoutDirection = values.getInt(defaultValue = View.LAYOUT_DIRECTION_LOCALE)
    }

    override fun updateRemoteView(views: RemoteViews, viewId: Int, vararg values: Any) {
        views.setInt(
            viewId, "setLayoutDirection", values.getInt(defaultValue = View.LAYOUT_DIRECTION_LOCALE)
        )
    }
}

// setFocusedByDefault
@MagnetPiece("setFocusedByDefault", [MagnetPiece.ValueType.Boolean], ["isFocusedByDefault"])
class FocusedByDefaultPiece : Piece {
    override fun updateView(view: View, vararg values: Any) {
        view.isFocusedByDefault = values.getBoolean()
    }

    override fun updateRemoteView(views: RemoteViews, viewId: Int, vararg values: Any) {
        views.setBoolean(viewId, "setFocusedByDefault", values.getBoolean())
    }
}

// setRotation
@MagnetPiece("setRotation", [MagnetPiece.ValueType.Float], ["rotation"])
class RotationPiece : Piece {
    override fun updateView(view: View, vararg values: Any) {
        view.rotation = values.getFloat()
    }

    override fun updateRemoteView(views: RemoteViews, viewId: Int, vararg values: Any) {
        views.setFloat(viewId, "setRotation", values.getFloat())
    }
}

// setRotationY
@MagnetPiece("setRotationY", [MagnetPiece.ValueType.Float], ["rotationY"])
class RotationYPiece : Piece {
    override fun updateView(view: View, vararg values: Any) {
        view.rotationY = values.getFloat()
    }

    override fun updateRemoteView(views: RemoteViews, viewId: Int, vararg values: Any) {
        views.setFloat(viewId, "setRotationY", values.getFloat())
    }
}

// setRotationX
@MagnetPiece("setRotationX", [MagnetPiece.ValueType.Float], ["rotationX"])
class RotationXPiece : Piece {
    override fun updateView(view: View, vararg values: Any) {
        view.rotationX = values.getFloat()
    }

    override fun updateRemoteView(views: RemoteViews, viewId: Int, vararg values: Any) {
        views.setFloat(viewId, "setRotationX", values.getFloat())
    }
}

// setScaleX
@MagnetPiece("setScaleX", [MagnetPiece.ValueType.Float], ["scaleX"])
class ScaleXPiece : Piece {
    override fun updateView(view: View, vararg values: Any) {
        view.scaleX = values.getFloat()
    }

    override fun updateRemoteView(views: RemoteViews, viewId: Int, vararg values: Any) {
        views.setFloat(viewId, "setScaleX", values.getFloat())
    }
}

// setScaleY
@MagnetPiece("setScaleY", [MagnetPiece.ValueType.Float], ["scaleY"])
class ScaleYPiece : Piece {
    override fun updateView(view: View, vararg values: Any) {
        view.scaleY = values.getFloat()
    }

    override fun updateRemoteView(views: RemoteViews, viewId: Int, vararg values: Any) {
        views.setFloat(viewId, "setScaleY", values.getFloat())
    }
}

// setPivotX
@MagnetPiece("setPivotX", [MagnetPiece.ValueType.Float], ["pivotX"])
class PivotXPiece : Piece {
    override fun updateView(view: View, vararg values: Any) {
        view.pivotX = values.getFloat()
    }

    override fun updateRemoteView(views: RemoteViews, viewId: Int, vararg values: Any) {
        views.setFloat(viewId, "setPivotX", values.getFloat())
    }
}

// setPivotY
@MagnetPiece("setPivotY", [MagnetPiece.ValueType.Float], ["pivotY"])
class PivotYPiece : Piece {
    override fun updateView(view: View, vararg values: Any) {
        view.pivotY = values.getFloat()
    }

    override fun updateRemoteView(views: RemoteViews, viewId: Int, vararg values: Any) {
        views.setFloat(viewId, "setPivotY", values.getFloat())
    }
}

// setAlpha
@MagnetPiece("setAlpha", [MagnetPiece.ValueType.Float], ["alpha"])
class AlphaPiece : Piece {
    override fun updateView(view: View, vararg values: Any) {
        view.alpha = values.getFloat()
    }

    override fun updateRemoteView(views: RemoteViews, viewId: Int, vararg values: Any) {
        views.setFloat(viewId, "setAlpha", values.getFloat())
    }
}

// setElevation
@MagnetPiece("setElevation", [MagnetPiece.ValueType.Float], ["elevation"])
class ElevationPiece : Piece {
    override fun updateView(view: View, vararg values: Any) {
        view.elevation = values.getFloat()
    }

    override fun updateRemoteView(views: RemoteViews, viewId: Int, vararg values: Any) {
        views.setFloat(viewId, "setElevation", values.getFloat())
    }
}

// setTranslationX
@MagnetPiece("setTranslationX", [MagnetPiece.ValueType.Float], ["translationX"])
class TranslationXPiece : Piece {
    override fun updateView(view: View, vararg values: Any) {
        view.translationX = values.getFloat()
    }

    override fun updateRemoteView(views: RemoteViews, viewId: Int, vararg values: Any) {
        views.setFloat(viewId, "setTranslationX", values.getFloat())
    }
}

// setTranslationY
@MagnetPiece("setTranslationY", [MagnetPiece.ValueType.Float], ["translationY"])
class TranslationYPiece : Piece {
    override fun updateView(view: View, vararg values: Any) {
        view.translationY = values.getFloat()
    }

    override fun updateRemoteView(views: RemoteViews, viewId: Int, vararg values: Any) {
        views.setFloat(viewId, "setTranslationY", values.getFloat())
    }
}

// setTranslationZ
@MagnetPiece("setTranslationZ", [MagnetPiece.ValueType.Float], ["translationZ"])
class TranslationZPiece : Piece {
    override fun updateView(view: View, vararg values: Any) {
        view.translationZ = values.getFloat()
    }

    override fun updateRemoteView(views: RemoteViews, viewId: Int, vararg values: Any) {
        views.setFloat(viewId, "setTranslationZ", values.getFloat())
    }
}

// setClipToOutline
@MagnetPiece("setClipToOutline", [MagnetPiece.ValueType.Boolean], ["clipToOutline"])
class ClipToOutlinePiece : Piece {
    override fun updateView(view: View, vararg values: Any) {
        view.clipToOutline = values.getBoolean()
    }

    override fun updateRemoteView(views: RemoteViews, viewId: Int, vararg values: Any) {
        views.setBoolean(viewId, "setClipToOutline", values.getBoolean())
    }
}


// setForegroundTintList
@MagnetPiece("setForegroundTintList", [MagnetPiece.ValueType.ColorStateList], ["tint"])
class ForegroundTintListPiece : Piece {
    override fun updateView(view: View, vararg values: Any) {
        view.foregroundTintList = values.obtain()
    }

    override fun updateRemoteView(views: RemoteViews, viewId: Int, vararg values: Any) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            views.setColorStateList(viewId, "setForegroundTintList", values.obtain())
        }
    }
}

// setForegroundTintBlendMode
@MagnetPiece("setForegroundTintBlendMode", [MagnetPiece.ValueType.BlendMode], ["blendMode"])
class ForegroundTintBlendModePiece : Piece {
    override fun updateView(view: View, vararg values: Any) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            view.foregroundTintBlendMode = values.obtain()
        }
    }

    override fun updateRemoteView(views: RemoteViews, viewId: Int, vararg values: Any) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            views.setBlendMode(viewId, "setForegroundTintBlendMode", values.obtain())
        }
    }
}

// setMinimumHeight
@MagnetPiece("setMinimumHeight", [MagnetPiece.ValueType.Int], ["minimumHeight"])
class MinimumHeightPiece : Piece {
    override fun updateView(view: View, vararg values: Any) {
        view.minimumHeight = values.getInt()
    }

    override fun updateRemoteView(views: RemoteViews, viewId: Int, vararg values: Any) {
        views.setInt(viewId, "setMinimumHeight", values.getInt())
    }
}

// setMinimumWidth
@MagnetPiece("setMinimumWidth", [MagnetPiece.ValueType.Int], ["minimumWidth"])
class MinimumWidthPiece : Piece {
    override fun updateView(view: View, vararg values: Any) {
        view.minimumWidth = values.getInt()
    }

    override fun updateRemoteView(views: RemoteViews, viewId: Int, vararg values: Any) {
        views.setInt(viewId, "setMinimumWidth", values.getInt())
    }
}