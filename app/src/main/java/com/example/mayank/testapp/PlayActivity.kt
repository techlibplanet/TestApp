package com.example.mayank.testapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button

class PlayActivity : AppCompatActivity() {

    private lateinit var leftToRight: Animation
    private lateinit var rightToLeft : Animation
    private lateinit var singlePlayerButton : Button
    private lateinit var quickGameButton : Button
    private lateinit var multiplayerButton : Button
    private lateinit var invitationButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)

        rightToLeft = AnimationUtils.loadAnimation(this, R.anim.right_to_left)
        leftToRight = AnimationUtils.loadAnimation(this, R.anim.left_to_right)

        singlePlayerButton = findViewById(R.id.singlePlayerButton)
        quickGameButton = findViewById(R.id.quickGameButton)
        multiplayerButton = findViewById(R.id.multiplayerButton)
        invitationButton = findViewById(R.id.invitationButton)

        singlePlayerButton.animation = leftToRight
        quickGameButton.animation = rightToLeft
        multiplayerButton.animation = leftToRight
        invitationButton.animation = rightToLeft

    }
}
