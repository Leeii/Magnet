package com.magnetwidgets.magnet

import android.content.Context
import android.util.SparseArray
import android.view.LayoutInflater
import android.view.View
import android.widget.RemoteViews
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import com.magnetwidgets.magnet.impl.BackgroundColorPiece
import com.magnetwidgets.magnet.impl.BackgroundResourcePiece
import com.magnetwidgets.magnet.impl.text.TextViewTextPiece
import com.widgetsmagnet.ksp.MagnetPiece

class Magnet(
    context: Context,
    @LayoutRes val layout: Int,
    private val environment: Environment = Environment.app
) {

    companion object {
        private val _globalPieces = arrayOf(
            BackgroundResourcePiece(),
            BackgroundColorPiece(),
            TextViewTextPiece()
        )
        val globalPieces: HashMap<String, Piece> = hashMapOf<String, Piece>().apply {
            _globalPieces.forEach { this.register(it) }
        }

        fun app(context: Context, @LayoutRes layout: Int): Magnet {
            return Magnet(context, layout, Environment.app)
        }

        fun widget(context: Context, @LayoutRes layout: Int): Magnet {
            return Magnet(context, layout, Environment.widget)
        }
    }

    enum class Environment {
        widget, app
    }

    private var pieces: HashMap<String, Piece> = globalPieces
    private var childViews: SparseArray<View> = SparseArray()

    lateinit var rootView: View
    internal lateinit var rootRemoteViews: RemoteViews


    init {
        if (isApp()) {
            rootView = LayoutInflater.from(context).inflate(layout, null, false)
        } else {
            rootRemoteViews = RemoteViews(context.packageName, layout)
        }
    }

    fun findViewById(@IdRes viewId: Int): View? {
        return childViews[viewId] ?: rootView.findViewById<View?>(viewId)
            ?.also { childViews[viewId] = it }
    }

    fun execute(name: String, viewId: Int, vararg values: Any) {
        val piece = pieces[name] ?: return
        if (isApp()) {
            val view = findViewById(viewId) ?: return
            piece.updateView(view, *values)
        } else {
            piece.updateRemoteView(rootRemoteViews, viewId, *values)
        }
    }

    private fun isApp(): Boolean {
        return environment == Environment.app
    }
}

fun <T : Piece> HashMap<String, in Piece>.register(piece: T) {
    val magnetPiece =
        piece::class.annotations.first { it is MagnetPiece } as? MagnetPiece ?: return
    this[magnetPiece.name] = piece
}