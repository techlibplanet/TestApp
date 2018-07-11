package com.example.mayank.testapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button

class PlayActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var leftToRight: Animation
    private lateinit var rightToLeft : Animation
    private lateinit var singlePlayerButton : Button
    private lateinit var quickGameButton : Button
    private lateinit var multiplayerButton : Button
    private lateinit var invitationButton : Button

    private var CLICKABLES = intArrayOf(R.id.singlePlayerButton, R.id.multiplayerButton, R.id.quickGameButton, R.id.invitationButton)

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

        for (id in CLICKABLES){
            findViewById<Button>(id).setOnClickListener(this)
        }

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.singlePlayerButton->{
                val intent = Intent(this, ResultActivity::class.java)
                startActivity(intent)
            }
            R.id.quickGameButton ->{

            }

        }
    }
}
