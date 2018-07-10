package com.example.mayank.testapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var leftToRight: Animation
    private lateinit var rightToLeft : Animation
    private lateinit var buttonPlay :Button
    private lateinit var buttonAchievements :Button
    private lateinit var buttonLeaderboards : Button
    private lateinit var buttonWallet : Button
    private lateinit var buttonSignOut : Button

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

    }
}
