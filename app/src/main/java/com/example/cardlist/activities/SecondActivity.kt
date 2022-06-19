package com.example.cardlist.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.cardlist.R
import com.squareup.picasso.Picasso

class SecondActivity : AppCompatActivity() {
    lateinit var secend_Image: ImageView
    lateinit var second_Title: TextView
    lateinit var second_text: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val intent = intent
        val bundle = intent.getBundleExtra("bundle")


        secend_Image = findViewById(R.id.secend_Image)
        second_Title = findViewById(R.id.second_Title)
        second_text = findViewById(R.id.second_text)

        Picasso.with(secend_Image.context).load(bundle?.getString("imgURL").toString()).placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_background).into(secend_Image)
        second_Title.text = bundle?.getString("title").toString()
        second_text.text = bundle?.getString("content").toString()
    }
}