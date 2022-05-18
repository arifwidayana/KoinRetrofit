package com.arifwidayana.koinretrofit.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.arifwidayana.koinretrofit.R
import com.arifwidayana.koinretrofit.data.model.response.ResultMovies

class MoviesAdapter(private val listMovies: List<ResultMovies>): RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val bind = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return ViewHolder(bind)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tvTitle = holder.itemView.findViewById<TextView>(R.id.tv_title)
        tvTitle.text = listMovies[position].title
    }

    override fun getItemCount(): Int {
        return listMovies.size
    }
}