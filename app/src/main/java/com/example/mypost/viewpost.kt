package com.example.mypost

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.telecom.Call
import android.view.Window
import android.widget.TextView
import android.widget.Toast
import com.example.mypost.R
import com.example.mypost.R.*
import retrofit2.Callback
import retrofit2.Response

class viewpost : AppCompatActivity() {
    var postId=0
    lateinit var tvIdx:TextView
    lateinit var tvBodyx:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewpost)
        postId=intent.getIntExtra("POST_ID",0)

        var tvId=findViewById<TextView>(R.id.tvId)
        var tvBody=findViewById<TextView>(R.id.tvBody)
    }
    fun fetchPostId() {
        var apiClient = ApiClient.buildApiClient(ApiInterface::class.java)
        var request = apiClient.getPostById(postId)
        request.enqueue(object : Callback<post> {
            override fun onResponse(call: retrofit2.Call<post>, response: Response<post>) {

                if (response.isSuccessful){
                    var post=response.body()
                    tvBodyx.text=post?.title
                    tvIdx.text=post?.body
                }

            }

            override fun onFailure(call: retrofit2.Call<post>, t: Throwable) {
                Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()
            }


        })
    }}


