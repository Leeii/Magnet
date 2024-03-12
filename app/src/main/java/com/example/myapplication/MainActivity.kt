package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.magnetwidgets.magnet.Magnet
import com.magnetwidgets.magnet.impl.setBackgroundResource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val magnet = Magnet(this, R.layout.activity_main)
        setContentView(magnet.rootView)
        magnet.setBackgroundResource(R.id.textView, R.drawable.ic_launcher_background)
    }
}