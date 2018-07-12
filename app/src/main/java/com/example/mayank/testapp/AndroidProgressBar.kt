package com.example.mayank.testapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import java.util.*

class AndroidProgressBar : AppCompatActivity(), View.OnClickListener {

    private var progressBar : ProgressBar? = null
    val CLICKABLES = intArrayOf(R.id.buttonStart, R.id.buttonStop)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android_progress_bar)

        progressBar = findViewById(R.id.progressBar)

        for (id in CLICKABLES){
            findViewById<Button>(id).setOnClickListener(this)
        }
    }

    private val progressDialog  = ProgressDialog()

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.buttonStart ->{
                progressDialog.showProgressDialog(this)

                Timer().schedule(
                        object : TimerTask() {
                            override fun run() {
                                runOnUiThread {

                                    progressDialog.hideProgressDialog()
                                }
                            }
                        },
                        5000
                )



            }
            R.id.buttonStop ->{
//                progressBar?.visibility = View.GONE
                progressDialog.hideProgressDialog()
            }
        }
    }

}
