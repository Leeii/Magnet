package com.magnetwidgets.magnet.impl.image

import android.view.View
import android.widget.ImageView
import android.widget.RemoteViews
import com.magnetwidgets.magnet.Piece
import com.magnetwidgets.magnet.extension.getBitmap
import com.magnetwidgets.magnet.extension.getIcon
import com.magnetwidgets.magnet.extension.getInt
import com.magnetwidgets.magnet.extension.getUri
import com.widgetsmagnet.ksp.MagnetPiece

val imageViewPieces: Array<Piece> = arrayOf(
    ImageViewBitmapPiece(),
    ImageViewIconPiece(),
    ImageViewResourcePiece(),
    ImageViewUriPiece()
)

@MagnetPiece("setImageViewBitmap", MagnetPiece.ValueType.Bitmap)
class ImageViewBitmapPiece : Piece {
    override fun updateView(view: View, vararg values: Any) {
        (view as? ImageView)?.setImageBitmap(values.getBitmap())
    }

    override fun updateRemoteView(views: RemoteViews, viewId: Int, vararg values: Any) {
        views.setImageViewBitmap(viewId, values.getBitmap())
    }
}

@MagnetPiece("setImageViewIcon", MagnetPiece.ValueType.Icon)
class ImageViewIconPiece : Piece {
    override fun updateView(view: View, vararg values: Any) {
        (view as? ImageView)?.setImageIcon(values.getIcon())
    }

    override fun updateRemoteView(views: RemoteViews, viewId: Int, vararg values: Any) {
        views.setImageViewIcon(viewId, values.getIcon())
    }
}

@MagnetPiece("setImageViewResource", MagnetPiece.ValueType.Icon)
class ImageViewResourcePiece : Piece {
    override fun updateView(view: View, vararg values: Any) {
        (view as? ImageView)?.setImageResource(values.getInt())
    }

    override fun updateRemoteView(views: RemoteViews, viewId: Int, vararg values: Any) {
        views.setImageViewResource(viewId, values.getInt())
    }
}

@MagnetPiece("setImageViewUri", MagnetPiece.ValueType.Icon)
class ImageViewUriPiece : Piece {
    override fun updateView(view: View, vararg values: Any) {
        (view as? ImageView)?.setImageURI(values.getUri())
    }

    override fun updateRemoteView(views: RemoteViews, viewId: Int, vararg values: Any) {
        views.setImageViewUri(viewId, values.getUri())
    }
}

