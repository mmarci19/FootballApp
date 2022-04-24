
package com.example.footballapp.model

import com.google.gson.annotations.SerializedName


data class Model (
    @SerializedName("get"  ) var get  : String?            = null,
    @SerializedName("parameters" ) var params : Parameters?           = Parameters(),
    @SerializedName("errors" ) var errors : ArrayList<String> = arrayListOf(),
    @SerializedName("paging"  ) var paging  : Paging?         = Paging(),
    @SerializedName("results") var results: Number? = null,
    @SerializedName("response" ) var responses : ArrayList<FootballResponse>           = arrayListOf()

)