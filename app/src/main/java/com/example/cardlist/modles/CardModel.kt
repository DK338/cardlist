package com.example.cardlist.modles

import com.google.gson.annotations.SerializedName

data class CardModel (

    @SerializedName("title")
    var title:String,
    @SerializedName("content")
    var content:String,
    @SerializedName("msgTime")
    var msgTime:String,
    @SerializedName("img")
    var imgURL:String

)
