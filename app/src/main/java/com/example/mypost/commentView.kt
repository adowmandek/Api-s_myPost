package com.example.mypost

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Comment
import retrofit2.Callback
import retrofit2.Response

class commentView : AppCompatActivity() {
     var postComment=tvComment
    lateinit var tvComment: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comment_view)

        var tvComment=findViewById<TextView>(R.id.tvComment)

    }
    fun fetchPostComment() {
        var apiClient = ApiClient.buildApiClient(ApiInterface::class.java)
        var request = apiClient.getPostByComment(postComment)
        request.enqueue(object :Callback<post>)

            override fun onResponse(call: retrofit2.Call<post>, response: Response<post>) {
                if (response.isSuccessful) {
                    var post = response.body()
                    tvComment.text = post?.title
                }

            }
            override fun onFailure(call: retrofit2.Call<post>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }

        })
    }}
