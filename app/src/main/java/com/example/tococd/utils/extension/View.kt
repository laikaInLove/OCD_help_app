package com.example.tococd.utils.extension

import android.view.View
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
        .error(R.drawable.ic_error_conection)
        .into(this)
}

fun ImageView.loadImage(drawableId: Int) {
    Glide.with(this)
        .load(drawableId)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .error(R.drawable.ic_error_conection)
        .into(this)
}

fun View.show() {
    this.visibility = View.VISIBLE
}

fun View.hide() {
    this.visibility = View.GONE
}