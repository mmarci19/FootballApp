package com.example.footballapp.model

import com.google.gson.annotations.SerializedName

data class Paging (

    @SerializedName("current") var current: Number? = null,
    @SerializedName("total") var total: Number? = null

    )