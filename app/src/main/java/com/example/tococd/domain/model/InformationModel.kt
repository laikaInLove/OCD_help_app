package com.example.tococd.domain.model

import androidx.annotation.StringRes

class InformationModel(
    val imageDescription: Int,
    @StringRes val titleDescriptionResId: Int,
    @StringRes val descriptionResId: Int,
    val touchDescription: String,
    var expandable: Boolean = false) {
}