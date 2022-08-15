package com.example.tococd.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.isEmpty
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieDrawable
import com.example.tococd.HomeActivity
import com.example.tococd.R
import com.example.tococd.databinding.ActivityYourNameIsBinding
import www.sanju.motiontoast.MotionToast
import www.sanju.motiontoast.MotionToastStyle

class YourNameIs : AppCompatActivity() {

    private lateinit var binding: ActivityYourNameIsBinding
    override fun onCreate(savedInstanceState: Bundle?) {

//        if (SharedApp.prefs.name?.isNotEmpty() == true) {
//            startActivity(Intent(this, HomeActivity::class.java))
//        }

        super.onCreate(savedInstanceState)
        binding = ActivityYourNameIsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var like: Boolean = false
        like = likeAnimation(binding.buttonName, R.raw.start_button_obscure, like)

        if (binding.writing.isEmpty()) {
            binding.buttonName.setBackgroundResource(R.drawable.locked_button)
        }


        binding.buttonName.setOnClickListener {
            Log.d("sizeText", binding.editText.text?.length.toString())
            if (binding.editText.text?.length!! in 1..10) {
                // Use shared preference (save)
                //SharedApp.prefs.name = binding.editText.text.toString()

                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)

            } else {
                MotionToast.darkColorToast(
                    this,
                    "Incorrect name",
                    "Make sure your name contains characters but not exceed 10 characters",
                    MotionToastStyle.WARNING,
                    MotionToast.GRAVITY_BOTTOM,
                    MotionToast.LONG_DURATION,
                    ResourcesCompat.getFont(this, R.font.helvetica)
                )
            }
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

