package com.example.cardlist.adapter

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.cardlist.R
import com.example.cardlist.activities.SecondActivity
import com.example.cardlist.modles.CardModel
import com.squareup.picasso.Picasso


class DataAdapter (private val dataModels: MutableList<CardModel>): RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        return DataTimeViewHolder(layoutInflater.inflate(R.layout.layout_item,parent,false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val cardModel = dataModels.get(position)
        var title: TextView = holder.itemView.findViewById<TextView>(R.id.title)
        var imageView: ImageView = holder.itemView.findViewById<ImageView>(R.id.imageView)
        title.text = cardModel.title
        Picasso.with(imageView.context).load(cardModel.imgURL).placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_background).into(imageView)

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, SecondActivity::class.java)

            val bundle = Bundle().apply {

                putString("title", cardModel.title)
                putString("content", cardModel.content)
                putString("imgURL", cardModel.imgURL)

            }
            intent.putExtra("bundle", bundle)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return dataModels.size
    }

    class DataTimeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


}