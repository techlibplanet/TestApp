package com.example.mayank.testapp

import android.app.Dialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var leftToRight: Animation
    private lateinit var rightToLeft : Animation
    private lateinit var buttonPlay :Button
    private lateinit var buttonAchievements :Button
    private lateinit var buttonLeaderboards : Button
    private lateinit var buttonWallet : Button
    private lateinit var buttonSignOut : Button

    private val CLICKABLES = intArrayOf(R.id.buttonPlay, R.id.buttonAchievements, R.id.buttonLeaderboards, R.id.buttonWallet, R.id.buttonSignOut)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonPlay = findViewById(R.id.buttonPlay)
        buttonAchievements = findViewById(R.id.buttonAchievements)
        buttonLeaderboards = findViewById(R.id.buttonLeaderboards)
        buttonWallet = findViewById(R.id.buttonWallet)
        buttonSignOut = findViewById(R.id.buttonSignOut)
        rightToLeft = AnimationUtils.loadAnimation(this, R.anim.right_to_left)
        leftToRight = AnimationUtils.loadAnimation(this, R.anim.left_to_right)
        buttonPlay.animation = rightToLeft
        buttonAchievements.animation = leftToRight
        buttonLeaderboards.animation = rightToLeft
        buttonWallet.animation = leftToRight
        buttonSignOut.animation = rightToLeft

        for (id in CLICKABLES){
            findViewById<Button>(id).setOnClickListener(this)
        }

    }


    override fun onClick(v: View?) {
        when(v?.id){
            R.id.buttonPlay ->{
                val intent = Intent(this, PlayActivity::class.java)
                startActivity(intent)

            }

            R.id.buttonAchievements ->{
                val showDialog = ShowDialog()
                showDialog.dialog(this@MainActivity, "Play Games", "This is a sample dialog")
            }

            R.id.buttonWallet ->{
                val intent = Intent(this, WalletActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
