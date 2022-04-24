package com.example.footballapp.model

import androidx.compose.runtime.Immutable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


data class Venue (

    @PrimaryKey @SerializedName("id"   ) var id   : Int?    = null,
    @SerializedName("name" ) var name : String? = null,
    @SerializedName("address" ) var address : String? = null,
    @SerializedName("city" ) var city : String? = null,
    @SerializedName("capacity") var capacity : Number? = null,
    @SerializedName("surface") var surface : String? = null,
    @SerializedName("image") var image : String? = null

)