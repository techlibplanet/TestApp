package com.example.mayank.testapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.mayank.testapp.adapter.ResultViewAdapter
import com.example.mayank.testapp.adapter.ResultViewModel

class ResultActivity : AppCompatActivity() {

    private lateinit var resultRecyclerView: RecyclerView
    val adapter: ResultViewAdapter by lazy { ResultViewAdapter() }
    lateinit var modelList: MutableList<ResultViewModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        modelList = mutableListOf<ResultViewModel>()

        resultRecyclerView = findViewById(R.id.result_recycler_view)
        resultRecyclerView.layoutManager = LinearLayoutManager(this)
        resultRecyclerView.setHasFixedSize(true)
        resultRecyclerView.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))

        resultRecyclerView.adapter = adapter
        setSettingsItem()
    }

    private fun setSettingsItem() {
        modelList.clear()
        modelList.add(ResultViewModel("Mayank Sharma","20", "20","20", "Total Points : 100"))
        modelList.add(ResultViewModel("Priyank Sharma","20", "20","20", "Total Points : 100"))
        setRecyclerViewAdapter(modelList)
    }

    private fun setRecyclerViewAdapter(list: List<ResultViewModel>) {
        adapter.items = list
        adapter.notifyDataSetChanged()
    }
}
