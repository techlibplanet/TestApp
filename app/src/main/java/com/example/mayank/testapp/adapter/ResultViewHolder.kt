package com.example.mayank.testapp.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.mayank.testapp.R

class ResultViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bindView(context : Context, resultViewModel: ResultViewModel, position: Int){
        val textViewPlayerName = itemView.findViewById<TextView>(R.id.textViewName)
        val textViewBidPoints = itemView.findViewById<TextView>(R.id.textViewBidPoints)
        val textViewLoosePoints = itemView.findViewById<TextView>(R.id.textViewLoosePoints)
        val textViewWinPoints = itemView.findViewById<TextView>(R.id.textViewWinPoints)
//        val textViewTotalPoints = itemView.findViewById<TextView>(R.id.textViewTotalPoints)


        textViewPlayerName.text = resultViewModel.playerName
        textViewBidPoints.text = resultViewModel.bidPoints
        textViewLoosePoints.text = resultViewModel.loosePoints
        textViewWinPoints.text = resultViewModel.winPoints
//        textViewTotalPoints.text = resultViewModel.totalPoints

    }
}