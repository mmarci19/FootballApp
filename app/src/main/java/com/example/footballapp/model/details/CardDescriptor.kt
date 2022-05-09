package com.example.footballapp.model.details

import com.google.gson.annotations.SerializedName

data class CardDescriptor (

    @SerializedName("total"      ) var total      : Int?    = null,
    @SerializedName("percentage" ) var percentage : String? = null

)