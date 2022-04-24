package com.hima.internalpracticaldemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var animation = AnimationUtils.loadAnimation(this,R.anim.rotate_animation)
        imgele.startAnimation(animation)
        Handler().postDelayed({
            val intent = Intent(this,registration_activity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}