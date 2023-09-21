package com.zireddinismayilov.githubusersapiproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.zireddinismayilov.githubusersapiproject.R
import com.zireddinismayilov.githubusersapiproject.data.RepositoryDTO

class Adapter(var data: RepositoryDTO) : RecyclerView.Adapter<Adapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val avatar = itemView.findViewById<ImageView>(R.id.avatarImage)
        val username = itemView.findViewById<TextView>(R.id.username)
        val reponame = itemView.findViewById<TextView>(R.id.repoName)
        val starsCount = itemView.findViewById<TextView>(R.id.starsCount)
        var description = itemView.findViewById<TextView>(R.id.description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_item, parent, false))
    }

    override fun getItemCount(): Int {
        return data.items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataValue = data.items[position]

        holder.reponame.text = dataValue.name
        holder.username.text = dataValue.owner.login
        holder.starsCount.text = dataValue.stargazerscount.toString()

        if (!dataValue.description.isNullOrEmpty()) {
            holder.description.text = dataValue.description
        }
        if (dataValue.owner.avatarurl.isNotEmpty()) {
            Picasso.get().load(dataValue.owner.avatarurl).into(holder.avatar)
        }

    }

}