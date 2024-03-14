package com.example.myapplication

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.graphics.Color
import android.util.TypedValue
import com.magnetwidgets.magnet.Magnet
import com.magnetwidgets.magnet.impl.text.setText
import com.magnetwidgets.magnet.impl.text.setTextColor
import com.magnetwidgets.magnet.impl.text.setTextSize
import com.magnetwidgets.magnet.impl.text.setTextViewCompoundDrawables

class SmallWidget : AppWidgetProvider() {
    override fun onUpdate(
        context: Context, appWidgetManager: AppWidgetManager?, appWidgetIds: IntArray?
    ) {
        val magnet = Magnet.widget(context, R.layout.widget_small_test)
        magnet.setText(R.id.text, "我是文本")
        magnet.setTextColor(R.id.text, Color.RED)
        magnet.setTextSize(R.id.text, TypedValue.COMPLEX_UNIT_SP, 24f)
        magnet.setTextViewCompoundDrawables(R.id.text, R.mipmap.ic_launcher, 0, 0, 0)
        appWidgetManager?.updateAppWidget(appWidgetIds, magnet.rootRemoteViews)
    }
}