package com.example.cardlist.network

import com.example.cardlist.modles.CardModel
import com.example.cardlist.responses.DataResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    //    https://smuat.megatime.com.tw/EAS/Apps/systex/hr_elearning/hr_elearning_20220602_181350.json
    @GET("Apps/systex/hr_elearning/hr_elearning_20220602_181350.json")
    fun getDataResponse(): Call<DataResponse>
}