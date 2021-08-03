package com.example.mypost

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {
    lateinit var rvPost: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fetchPosts()

    }
    fun fetchPosts(){
        var retrofit=ApiClient.buildApiClient(ApiInterface::class.java)
        var request=retrofit.getPosts()
        request.enqueue(object : retrofit2.Callback<List<post>?> {

            override fun onResponse(call: Call<List<post>?>, response: Response<List<post>?>) {
                if (response.isSuccessful){
                    var postList=response.body()!!
//                    if (postList!=null
                    rvPost=findViewById(R.id.rvPost)
                    var postRVAdapter=PostRVAdapter(postList,baseContext)
                    rvPost.layoutManager=LinearLayoutManager(baseContext)
                    rvPost.adapter=postRVAdapter
                    Toast.makeText(baseContext,postList.size.toString(),Toast.LENGTH_LONG).show()
                    Toast.makeText(baseContext,"${postList!!.size} posts",Toast.LENGTH_LONG).show()

                    var postDate= mutableListOf<post>()
                    for (x in 1..postList.size){
                        postDate.add(post(4,576,"The Kotlin","It mismatches the details written","We do what we love"))

                    }
                }

            }

            override fun onFailure(call: Call<List<post>?>, t: Throwable) {
                Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()

            }
        })


    }
}


