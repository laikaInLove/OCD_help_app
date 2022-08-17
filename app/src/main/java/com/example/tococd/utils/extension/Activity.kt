package com.example.tococd.utils.extension

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.annotation.StringRes
import com.example.tococd.R
import www.sanju.motiontoast.MotionToast
import www.sanju.motiontoast.MotionToastStyle

fun Activity.showMotionToastError(@StringRes titleId: Int, @StringRes messageId: Int) {
    MotionToast.darkToast(
        this,
        getString(titleId),
        getString(messageId),
        MotionToastStyle.ERROR,
        MotionToast.GRAVITY_BOTTOM,
        MotionToast.LONG_DURATION,
        resources.getFont(R.font.helvetica)
    )
}

fun Activity.initUrl(url: String) {
    val uri = Uri.parse(url)
    Intent(Intent.ACTION_VIEW, uri).apply {
        startActivity(this)
    }
}