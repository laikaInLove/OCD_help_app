package com.example.tococd.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieDrawable
import com.example.tococd.R
import com.example.tococd.databinding.ActivitySplashScreenBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding
    private val activityScope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Add animations
        val bottomAnimation = AnimationUtils.loadAnimation(this, R.anim.scrolling_down)
        binding.splashScreenDown.startAnimation(bottomAnimation)

        val headAnimation = AnimationUtils.loadAnimation(this, R.anim.scrolling_up)
        binding.splashScreenUp.startAnimation(headAnimation)

        var like: Boolean = false
        like =
            likeAnimation(binding.splashScreenUp as LottieAnimationView, R.raw.mental_help, like)


        activityScope.launch {
            delay(2700)
            startActivity(
                Intent(
                    applicationContext,
                    ViewPagerActivity::class.java
                )
            ) startActivity (intent)
            finish()
        }
    }

    private fun likeAnimation(
        imageView: LottieAnimationView,
        animation: Int,
        like: Boolean
    ): Boolean {
        imageView.setAnimation(animation)
        imageView.repeatCount = LottieDrawable.INFINITE
        imageView.playAnimation()
        return !like
    }
}

private infix fun Unit.startActivity(intent: Intent?) {
}

