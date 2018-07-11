package com.example.mayank.testapp.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.mayank.testapp.R

class ResultViewAdapter: RecyclerView.Adapter<ResultViewHolder>() {

    var items: List<ResultViewModel> = emptyList()
    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultViewHolder {
        context = parent.context
        val v = LayoutInflater.from(context).inflate(R.layout.result_row, parent, false)
        return ResultViewHolder(v)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ResultViewHolder, position: Int) {
        holder.bindView(context,items[position], position)
    }
}