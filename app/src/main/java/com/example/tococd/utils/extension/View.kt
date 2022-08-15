package com.example.tococd.utils.extension

import android.widget.ImageView
import androidx.annotation.RawRes
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.tococd.R

fun LottieAnimationView.likeAnimation(@RawRes animationId: Int, isLiked: Boolean): Boolean {
    this.setAnimation(animationId)
    this.repeatCount = LottieDrawable.INFINITE
    this.playAnimation()
    return !isLiked
}

fun ImageView.loadUrlImage(url: String) {
    Glide.with(this)
        .load(url)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .placeholder(R.drawable.ic_error_conection)
        .into(this)
}