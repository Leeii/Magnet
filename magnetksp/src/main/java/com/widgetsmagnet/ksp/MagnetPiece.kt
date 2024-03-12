package com.widgetsmagnet.ksp

annotation class MagnetPiece(val name: String, val valueType: ValueType) {
    enum class ValueType {
        Any,
        Int, Short, Float, Byte, Char, Double, Bool,
        CharSequence,
        Icon, BlendMode, Bundle, Bitmap, ColorStateList,
        URI, Intent, PendingIntent,
        Magnet;

        fun packageName(): String? {
            return when {
                this == Bundle -> "android.os"
                this == Bitmap -> "android.graphics"
                this == Icon -> "android.graphics.drawable"
                this == BlendMode -> "android.graphics"
                this == ColorStateList -> "android.content.res"
                this == URI -> "android.net"
                this == Intent -> "android.content"
                this == PendingIntent -> "android.app"
                this == Magnet -> "com.magnetwidgets.magnet"
                else -> null
            }
        }

        fun needTypedArray(): Boolean {
            return when {
                this == Int -> true
                this == Short -> true
                this == Float -> true
                this == Byte -> true
                this == Char -> true
                this == Double -> true
                this == Bool -> true
                else -> false
            }
        }
    }
}
