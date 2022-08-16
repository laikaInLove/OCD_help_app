package com.example.tococd.utils.extension

import android.content.Context
import android.widget.TextView
import androidx.annotation.RawRes
import androidx.annotation.StringRes
import com.airbnb.lottie.LottieAnimationView
import com.example.tococd.R
import com.google.android.material.button.MaterialButton

fun Context.showOnboardingDialog(
    @StringRes titleId: Int,
    @StringRes descriptionId: Int,
    @StringRes secondTitleId: Int,
    @StringRes secondDescriptionId: Int,
    @RawRes lottieAnimationView: Int,
    @RawRes secondLottieAnimationView: Int,
) {
    val context = this
    val alertDialog = androidx.appcompat.app.AlertDialog.Builder(context).setCancelable(false)
    val view =
        android.view.LayoutInflater.from(context)
            .inflate(R.layout.dialog_welcome_onboarding, null)
    val customDialog = alertDialog
        .setView(view)
        .create()
    val dialogButton = view.findViewById<MaterialButton>(R.id.dialogBtn)
    val lottieView =
        view.findViewById<LottieAnimationView>(R.id.dialogAnimationLav)
    val descriptionText = view.findViewById<TextView>(R.id.dialogDescriptionTv)
    val titleText = view.findViewById<TextView>(R.id.dialogTitleTv)

    lottieView.setAnimation(lottieAnimationView)
    descriptionText.text = getString(descriptionId)
    titleText.text = getString(titleId)

    dialogButton.setOnClickListener {
        if (dialogButton.text.equals(getString(R.string.close_option))) {
            customDialog.dismiss()
        } else {
            lottieView.setAnimation(secondLottieAnimationView)
            lottieView.playAnimation()
            descriptionText.text = getString(secondDescriptionId)
            titleText.text = getString(secondTitleId)
            dialogButton.text = getString(R.string.close_option)
        }
    }
    customDialog.show()
}