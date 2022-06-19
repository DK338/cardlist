package com.example.cardlist.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.cardlist.modles.CardModel
import com.example.cardlist.repositories.DataRepository
import com.example.cardlist.responses.DataResponse

class DataResponseViewModel: ViewModel() {

    var datasRepository: DataRepository = DataRepository()

    fun getDataResponses(): LiveData<DataResponse>? = datasRepository.getDataResponses()

}