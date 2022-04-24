package com.example.footballapp.model

import androidx.compose.runtime.Immutable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
@Immutable
data class Team (

    @PrimaryKey @SerializedName("id"   ) var id   : Int?    = null,
    @SerializedName("name" ) var name : String? = null,
    @SerializedName("code" ) var code : String? = null,
    @SerializedName("logo" ) var logo : String? = null,
    @SerializedName("country") var country : String? = null,
    @SerializedName("national") var national : Boolean? = null,
    var league_id : String? = null

)




