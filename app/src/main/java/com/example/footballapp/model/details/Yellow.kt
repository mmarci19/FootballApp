package com.example.footballapp.model.details

import com.google.gson.annotations.SerializedName


data class Yellow (
    @SerializedName("0-15"    ) var firstQuarter    : CardDescriptor    = CardDescriptor()
)