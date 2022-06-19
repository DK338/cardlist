package com.example.cardlist.repositories

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.cardlist.modles.CardModel
import com.example.cardlist.network.ApiClient
import com.example.cardlist.network.ApiService
import com.example.cardlist.responses.DataResponse
import retrofit2.Call
import retrofit2.Response

class DataRepository {

    val apiService: ApiService = ApiClient().getRetrofit().create(ApiService::class.java)

    fun getDataResponses(): MutableLiveData<DataResponse>? {

        var data: MutableLiveData<DataResponse> = MutableLiveData()

        apiService.getDataResponse().enqueue(object : retrofit2.Callback<DataResponse> {
            override fun onResponse(call: Call<DataResponse>, response: Response<DataResponse>) {
                Log.d("success", response.body().toString())
                data.value = response.body()
            }

            override fun onFailure(call: Call<DataResponse>, t: Throwable) {
                Log.d("Fail", "noData")
                data.value = null
            }
        })
        return data
    }

}