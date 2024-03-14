package com.magnetwidgets.magnet.impl.image

import android.widget.ImageView
import android.widget.RemoteViews
import com.magnetwidgets.magnet.BasePiece
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

@MagnetPiece("setImageViewBitmap", [MagnetPiece.ValueType.Bitmap], ["bitmap"])
class ImageViewBitmapPiece : BasePiece<ImageView>() {
    override fun updateAppView(view: ImageView, vararg values: Any) {
        view.setImageBitmap(values.getBitmap())
    }

    override fun updateRemoteView(views: RemoteViews, viewId: Int, vararg values: Any) {
        views.setImageViewBitmap(viewId, values.getBitmap())
    }
}

@MagnetPiece("setImageViewIcon", [MagnetPiece.ValueType.Icon], ["icon"])
class ImageViewIconPiece : BasePiece<ImageView>() {

    override fun updateAppView(view: ImageView, vararg values: Any) {
        view.setImageIcon(values.getIcon())
    }

    override fun updateRemoteView(views: RemoteViews, viewId: Int, vararg values: Any) {
        views.setImageViewIcon(viewId, values.getIcon())
    }
}

@MagnetPiece("setImageViewResource", [MagnetPiece.ValueType.Int], ["id"])
class ImageViewResourcePiece : BasePiece<ImageView>() {

    override fun updateAppView(view: ImageView, vararg values: Any) {
        view.setImageResource(values.getInt())
    }

    override fun updateRemoteView(views: RemoteViews, viewId: Int, vararg values: Any) {
        views.setImageViewResource(viewId, values.getInt())
    }
}

@MagnetPiece("setImageViewUri", [MagnetPiece.ValueType.Uri], ["imageUri"])
class ImageViewUriPiece : BasePiece<ImageView>() {

    override fun updateAppView(view: ImageView, vararg values: Any) {
        view.setImageURI(values.getUri())
    }

    override fun updateRemoteView(views: RemoteViews, viewId: Int, vararg values: Any) {
        views.setImageViewUri(viewId, values.getUri())
    }
}

