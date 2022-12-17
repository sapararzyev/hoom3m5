package com.example.hoom3m5.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.hoom3m5.*
import com.example.hoom3m5.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private  var adapter =  ImageAdapter(mutableListOf())
    private var page = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvImeges.adapter = adapter
       binding.btnNext.setOnClickListener {
           page++
           getImagesPages()
       }
        binding.btnReques.setOnClickListener {
            getImages()
        }
    }
    private fun getImages(){
        App.api.getimeg(q = binding.edReques.text.toString(), page = page, per_page = 10).enqueue(
            object : Callback<PixModel>{
                override fun onResponse(call: Call<PixModel>, response: Response<PixModel>) {
                  Log.d("request","onResponse:${response.body()}")
                        adapter = ImageAdapter(response.body()!!.hits as MutableList<ImageModel>)
                    binding.rvImeges.adapter = adapter
                }
                override fun onFailure(call: Call<PixModel>, t: Throwable) {
                   Log.d("request","onfailuar:${t.stackTrace}")
                }
            }) }

    private fun getImagesPages(){
        App.api.getimeg(q ="pokemon", page = page, per_page = 10).enqueue(
            object : Callback<PixModel>{
                override fun onResponse(call: Call<PixModel>, response: Response<PixModel>) {
                    Log.d("request","onResponse:${response.body()!!  .hits}")

                    adapter.getNewElemens(response.body()!!.hits as MutableList<ImageModel>)
                    binding.rvImeges.adapter = adapter
                }
                override fun onFailure(call: Call<PixModel>, t: Throwable) {
                    Log.d("request","onfailuar:${t.stackTrace}")
                } })}
}