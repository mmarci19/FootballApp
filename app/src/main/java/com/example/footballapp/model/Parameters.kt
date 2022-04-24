package com.example.footballapp.model

import com.google.gson.annotations.SerializedName

data class Parameters (
    @SerializedName("season")var season: Number? = null,
    @SerializedName("type")var type: String? = null,
    @SerializedName("code")var code: String? = null
)