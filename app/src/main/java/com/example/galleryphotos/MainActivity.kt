package com.example.galleryphotos

import android.content.Intent
import android.icu.text.Transliterator.Position
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView:RecyclerView
    private lateinit var viewModel: PhotoViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerview)
        viewModel  = ViewModelProvider(this)[PhotoViewModel::class.java]
        viewModel.getPhotos()
        viewModel.observeGetPhotos().observe(this) {
            val adaptor = GalleryAdapter(it)
            val layout = GridLayoutManager(this@MainActivity, 2)
            recyclerView.adapter = adaptor
            recyclerView.layoutManager = layout
        }


    }
}
