package com.widgetsmagnet.ksp

annotation class MagnetPiece(
    val name: String,
    val parameterTypes: Array<ValueType>,
    val parameterNames: Array<String> = []
) {
    enum class ValueType {
        Any,
        Int, Short, Float, Byte, Char, Double, Boolean, Long,
        CharSequence,
        Icon, BlendMode, Bundle, Bitmap, ColorStateList,
        Uri, Intent, PendingIntent, Magnet;

        fun packageName(): String? {
            return when {
                this == Bundle -> "android.os"
                this == Bitmap -> "android.graphics"
                this == Icon -> "android.graphics.drawable"
                this == BlendMode -> "android.graphics"
                this == ColorStateList -> "android.content.res"
                this == Uri -> "android.net"
                this == Intent -> "android.content"
                this == PendingIntent -> "android.app"
                this == Magnet -> "com.magnetwidgets.magnet"
                else -> null
            }
        }

        fun needTypedArray(): kotlin.Boolean {
            return when {
                this == Int -> true
                this == Short -> true
                this == Float -> true
                this == Byte -> true
                this == Char -> true
                this == Double -> true
                this == Boolean -> true
                this == Long -> true
                else -> false
            }
        }
    }
}

val MagnetPiece.identifier get() = "$name(${parameterTypes.map { it.name }.joinToString(", ")})"