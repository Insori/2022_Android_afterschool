package com.example.githubusersearch

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GitHubAdapter(val datalist: List<GitHubRepo>)
    :   RecyclerView.Adapter<GitHubAdapter.GitHubViewHolder>() {

    class GitHubViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitHubViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(viewType, parent, false)
        return GitHubViewHolder(view)
    }

    override fun onBindViewHolder(holder: GitHubViewHolder, position: Int) {
        holder.view.findViewById<TextView>(R.id.repo_name).text = datalist[position].name
        holder.view.findViewById<TextView>(R.id.repo_description).text = datalist[position].description
        holder.view.findViewById<TextView>(R.id.repo_forks_count).text = datalist[position].forks_count.toString()
        holder.view.findViewById<TextView>(R.id.repo_watchers_count).text = datalist[position].watchers_count.toString()
        holder.view.findViewById<TextView>(R.id.repo_stargazers_count).text = datalist[position].stargazers_count.toString()
    }

    override fun getItemCount(): Int {
        return datalist.size
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.repo_item
    }
}