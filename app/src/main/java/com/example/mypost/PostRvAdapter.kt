package com.example.mypost

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
    class PostRVAdapter(var PostList:List<post>, var context:Context):RecyclerView.Adapter<ViewHolderPost>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderPost {
            var itemView=LayoutInflater.from(parent.context).inflate(R.layout.postitem,parent,false)
            return ViewHolderPost(itemView)


        }


        override fun onBindViewHolder(holder: ViewHolderPost, position: Int) {
            var currentPost=PostList.get(position)
            holder.tvUserId.text=currentPost.userId.toString()
            holder.tvId.text=currentPost.id.toString()
            holder.tvTitle.text=currentPost.title
            holder.tvBody.text=currentPost.body


            holder.rvPost.setOnClickListener {
                var intent=Intent(context,ViewHolderPost::class.java)
                intent.putExtra("POST_ID",currentPost.id)
                intent.addFlags(intent.flags)
                context.startActivity(intent)




                holder.rvComments.setOnClickListener {
                var intent=Intent(context,ViewHolderPost::class.java)
                    intent.putExtra("POST_COMMENT",currentPost.comment)
                    intent.addFlags(intent.flags)
                    context.startActivity(intent)

                }
            }


        }

        override fun getItemCount(): Int {
            return PostList.size
        }
    }

    class ViewHolderPost(itemView:View):RecyclerView.ViewHolder(itemView){
        var tvUserId=itemView.findViewById<TextView>(R.id.tvUserId)
        var tvId=itemView.findViewById<TextView>(R.id.tvId)
        var tvTitle=itemView.findViewById<TextView>(R.id.tvTitle)
        var tvBody=itemView.findViewById<TextView>(R.id.tvBody)
        var rvPost=itemView.findViewById<CardView>(R.id.rvPost)
        var rvComments=itemView.findViewById<TextView>(R.id.rvComments)

    }
