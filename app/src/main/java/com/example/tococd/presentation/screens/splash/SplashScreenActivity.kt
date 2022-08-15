package com.example.tococd.presentation.screens.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.tococd.R
import com.example.tococd.databinding.ActivitySplashScreenBinding
import com.example.tococd.view.activity.ViewPagerActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        animateText()
        goToHome()
    }

    private fun animateText() {
        val bottomAnimation = AnimationUtils.loadAnimation(this, R.anim.scrolling_down)
        val headAnimation = AnimationUtils.loadAnimation(this, R.anim.scrolling_up)
        with(binding) {
            splashScreenDown.startAnimation(bottomAnimation)
            splashScreenUp.startAnimation(headAnimation)
        }
    }

    private fun goToHome() {
        lifecycleScope.launch {
            delay(2700)
            Intent(this@SplashScreenActivity, ViewPagerActivity::class.java).apply {
                startActivity(this)
                finish()
            }
        }
    }
}

