package com.example.galleryphotos

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PhotoViewModel: ViewModel() {
    private val mutablePhotosLiveData = MutableLiveData<Photos>()

    fun getPhotos(){
        val retrofitInstance = Retrofit.Builder().baseUrl("https://www.flickr.com").addConverterFactory(
            GsonConverterFactory.create()).build()
        val retrofitData = retrofitInstance.create(GalleryInterface::class.java)
        val call = retrofitData.getData()
        call.enqueue(object:Callback<Photos>{
            override fun onResponse(call: Call<Photos>, response: Response<Photos>) {
                mutablePhotosLiveData.value = response.body()

            }

            override fun onFailure(call: Call<Photos>, t: Throwable) {
                Log.d("Error",t.message.toString())
            }

        })
    }
    fun observeGetPhotos():LiveData<Photos> = mutablePhotosLiveData
}