package com.example.tococd.data.remote.response

import com.google.gson.annotations.SerializedName

data class PsychologistsResponse(
    @SerializedName("id") var id: Int,
    @SerializedName("imagePerson") var imagePerson: String,
    @SerializedName("imageType") var imageType: String,
    @SerializedName("imageCountry") var imageCountry: String,
    @SerializedName("name") var name: String,
    @SerializedName("specialties") var specialties: String,
    @SerializedName("contact") var contact: String
)
