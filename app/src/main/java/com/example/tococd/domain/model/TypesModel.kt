package com.example.tococd.domain.model

import androidx.annotation.StringRes

data class TypesModel(
    val imageTypes: String,
    @StringRes val tittleTypes: Int,
    @StringRes val descriptionTypes: Int,
    var buttonTypes: String
)