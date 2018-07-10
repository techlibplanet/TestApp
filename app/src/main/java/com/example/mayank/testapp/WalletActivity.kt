package com.example.mayank.testapp

import android.icu.util.Currency
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import java.util.*

class WalletActivity : AppCompatActivity() {

    private lateinit var leftToRight: Animation
    private lateinit var rightToLeft : Animation
    private lateinit var buttonAddPoints : Button
    private lateinit var buttonWithdrawalPoints : Button
    private lateinit var buttonTransferPoints : Button
    private lateinit var buttonTransactions : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wallet)

        buttonAddPoints = findViewById(R.id.buttonAddPoints)
        buttonWithdrawalPoints = findViewById(R.id.buttonWithdrawalPoints)
        buttonTransactions = findViewById(R.id.buttonTransactions)
        buttonTransferPoints = findViewById(R.id.buttonTransferPoints)
        rightToLeft = AnimationUtils.loadAnimation(this, R.anim.right_to_left)
        leftToRight = AnimationUtils.loadAnimation(this, R.anim.left_to_right)
        buttonAddPoints.animation = leftToRight
        buttonWithdrawalPoints.animation = rightToLeft
        buttonTransferPoints.animation = leftToRight
        buttonTransactions.animation = rightToLeft



        //you can get symbol also if you write string of your desired currency
        val currencySymbol = Utils.getCurrencySymbol("INR");

        findViewById<TextView>(R.id.amountTextView).text = "$currencySymbol 135.00"

    }


}
