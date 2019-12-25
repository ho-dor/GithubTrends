package com.kunalrai.githubtrends

import android.content.Context
import android.content.ContextWrapper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.pixplicity.easyprefs.library.Prefs

class ListAdapter(private val context: Context?) : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var repoList: ArrayList<Repo> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.repo_item,parent,false)
        return MyViewHolder(view,this)
    }

    override fun getItemCount(): Int {
        return repoList.size
    }

    fun swapData(repo: List<Repo>){
        this.repoList.clear()
        this.repoList.addAll(repo)
        notifyDataSetChanged()
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.author.text = repoList[position].author

        holder.repo.text = repoList[position].name

        Glide.with(context!!).load(repoList[position].avatar)
            .apply(RequestOptions().centerCrop())
            .into(holder.image)
    }

    class MyViewHolder(itemView: View?, listAdapter: ListAdapter) : RecyclerView.ViewHolder(itemView!!) {

        val author: TextView = itemView!!.findViewById(R.id.owner_name)
        val image: ImageView = itemView!!.findViewById(R.id.owner_image)
        val repo: TextView = itemView!!.findViewById(R.id.repo_name)

        init {
            itemView!!.setOnClickListener(View.OnClickListener {
                val pos = adapterPosition

                Prefs.Builder()
                    .setContext(itemView.context)
                    .setMode(ContextWrapper.MODE_PRIVATE)
                    .setPrefsName("trending")
                    .setUseDefaultSharedPreference(true)
                    .build()

                Prefs.putString("author",listAdapter.repoList[pos].author)
                Prefs.putString("name", listAdapter.repoList[pos].name)
                Prefs.putString("stars", listAdapter.repoList[pos].stars)
                Prefs.putString("forks", listAdapter.repoList[pos].forks)
                Prefs.putString("desc", listAdapter.repoList[pos].desc)
                Prefs.putString("avatar", listAdapter.repoList[pos].avatar)
                Prefs.putString("language", listAdapter.repoList[pos].language)

                itemView.findNavController().navigate(R.id.action_listFragment_to_detailsFragment)
            })
        }
    }
}