package com.kunalrai.githubtrends

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil


class RepositoryAdapter(repoList: List<Repo>, context: Context?) : RecyclerView.Adapter<RepositoryAdapter.ViewHolder>() {

    private var repoList: List<Repo>
    private var context: Context? = null

    init {
         this.context = context
        this.repoList = repoList
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.repo_item, parent, false
        ))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //holder.bind(repoList.get(position))
    }

    override fun getItemCount(): Int = repoList.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
//        public RepoItem
//        fun bind(obj: Any) {
//            repo.setVariable(BR.model, obj)
//            itemRowBinding.executePendingBindings()
//        }
    }
}