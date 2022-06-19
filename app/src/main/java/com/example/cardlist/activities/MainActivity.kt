package com.example.cardlist.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cardlist.R
import com.example.cardlist.adapter.DataAdapter
import com.example.cardlist.databinding.ActivityMainBinding
import com.example.cardlist.modles.CardModel
import com.example.cardlist.responses.DataResponse
import com.example.cardlist.viewmodels.DataResponseViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: DataResponseViewModel
    private var dataModels: MutableList<CardModel> = mutableListOf<CardModel>()
    private lateinit var dataAdapter: DataAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(DataResponseViewModel::class.java)


        dataAdapter = DataAdapter(dataModels)
        val linearLayoutManager: LinearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        binding.recyclerView.layoutManager = linearLayoutManager
        binding.recyclerView.adapter = dataAdapter
        binding.recyclerView.setHasFixedSize(true)

        getDataResponses()

    }


    fun getDataResponses() {
        var dataResponse: Observer<DataResponse> = Observer<DataResponse> {
//            Toast.makeText(this,"測試:"+it.dataList.get(0).title,Toast.LENGTH_LONG).show()
            dataModels.addAll(it.dataList)
            dataAdapter.notifyDataSetChanged()
        }
        viewModel.getDataResponses()?.observe(this, dataResponse)
    }
}