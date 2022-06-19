package com.example.cardlist.responses

import com.example.cardlist.modles.CardModel
import com.google.gson.annotations.SerializedName

data class DataResponse (

    @SerializedName("DataList")
    var dataList: List<CardModel>
    )
