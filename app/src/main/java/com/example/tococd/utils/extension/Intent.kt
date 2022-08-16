package com.example.tococd.utils.extension

import android.app.Activity
import android.content.Intent
import android.net.Uri

fun Activity.initUrl(url: String) {
    val uri = Uri.parse(url)
    Intent(Intent.ACTION_VIEW, uri).apply {
        startActivity(this)
    }
}