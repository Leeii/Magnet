package com.example.myapplication

import android.graphics.Color
import android.os.Bundle
import android.util.TypedValue
import android.view.ViewGroup
import androidx.activity.ComponentActivity
import com.magnetwidgets.magnet.Magnet
import com.magnetwidgets.magnet.impl.setBackgroundResource
import com.magnetwidgets.magnet.impl.text.setText
import com.magnetwidgets.magnet.impl.text.setTextColor
import com.magnetwidgets.magnet.impl.text.setTextSize
import com.magnetwidgets.magnet.impl.text.setTextViewCompoundDrawables

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val magnet = Magnet(this, R.layout.activity_main)
        setContentView(magnet.rootView)
        magnet.setBackgroundResource(R.id.textView, R.drawable.ic_launcher_background)

        val widget = Magnet(this, R.layout.widget_small_test)
        (magnet.rootView as? ViewGroup)?.addView(widget.rootView)
        widget.setText(R.id.text, "我是文本")
        widget.setTextColor(R.id.text, Color.RED)
        widget.setTextSize(R.id.text, TypedValue.COMPLEX_UNIT_SP, 24f)
        widget.setTextViewCompoundDrawables(R.id.text, R.mipmap.ic_launcher, 0, 0, 0)
    }
}