package com.kunalrai.githubtrends

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListAdapter(private val context: Context?, private val repoList: List<Repo>) : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.repo_item,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        Log.i("reposize: ",""+repoList.size)
        return repoList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.author.text = repoList[position].author

        holder.repo.text = repoList[position].name

        Glide.with(context!!).load(repoList[position].avatar)
            .apply(RequestOptions().centerCrop())
            .into(holder.image)
    }

    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {

        val author: TextView = itemView!!.findViewById(R.id.owner_name)
        val image: ImageView = itemView!!.findViewById(R.id.owner_image)
        val repo: TextView = itemView!!.findViewById(R.id.repo_name)


    }
}