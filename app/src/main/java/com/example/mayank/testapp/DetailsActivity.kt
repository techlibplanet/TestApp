package com.example.mayank.testapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import java.util.concurrent.TimeUnit

class DetailsActivity : AppCompatActivity(), View.OnClickListener {


    private var timerStatus = TimerStatus.STOPPED
    private var progressBar: ProgressBar? = null
    private var textViewSeconds: TextView? = null
    private var countDownTimer: CountDownTimer? = null
    private var timeCountInMilliSeconds = (1 * 10000).toLong()
    private var start: Boolean = false
    private lateinit var buttonStart: Button
    private lateinit var buttonStop: Button
    private lateinit var buttonReset: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        progressBar = findViewById(R.id.progressBar)
        textViewSeconds = findViewById(R.id.textViewSeconds)
        buttonStart = findViewById(R.id.buttonStart)
        buttonStop = findViewById(R.id.buttonStop)
        buttonReset = findViewById(R.id.buttonReset)
        buttonStart.setOnClickListener(this)
        buttonStop.setOnClickListener(this)
        buttonReset.setOnClickListener(this)

    }

    private enum class TimerStatus {
        STARTED,
        STOPPED
    }

    private fun startCountdownTimer() {
        countDownTimer = object : CountDownTimer(timeCountInMilliSeconds, 1000) {
            override fun onTick(millisUntilFinished: Long) {

//                textViewTime!!.text = hmsTimeFormatter(millisUntilFinished)
                textViewSeconds!!.text = secondsFormatter(millisUntilFinished)
                progressBar!!.progress = (millisUntilFinished / 1000).toInt()

            }

            override fun onFinish() {

//                textViewTime!!.text = hmsTimeFormatter(timeCountInMilliSeconds)
                textViewSeconds!!.text = secondsFormatter(timeCountInMilliSeconds)
                // call to initialize the progress bar values
                setProgressBarValue()


                // changing the timer status to stopped
                timerStatus = TimerStatus.STOPPED
            }

        }.start()
        countDownTimer!!.start()
    }

    private fun stopCountdownTimer() {
        if (timerStatus == TimerStatus.STARTED){
            countDownTimer?.cancel()
        }
    }

    private fun setProgressBarValue() {
        progressBar!!.max = timeCountInMilliSeconds.toInt() / 1000
        progressBar!!.progress = timeCountInMilliSeconds.toInt() * 1000
    }

    private fun secondsFormatter(milliSeconds: Long): String {
        return String.format("%02d", TimeUnit.MILLISECONDS.toSeconds(milliSeconds) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(milliSeconds)))
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.buttonStart -> {
                start()

            }
            R.id.buttonStop ->{
                stopCountdownTimer()
            }
            R.id.buttonReset ->{
                start()
            }
        }
    }

    private fun reset() {
        stopCountdownTimer()
        startCountdownTimer()
    }

    private fun start(){
        if (timerStatus == TimerStatus.STOPPED){
            setTimerValues()
            setProgressBarValue()
            timerStatus = TimerStatus.STARTED
            startCountdownTimer()
            return
        }
        reset()
    }

    private fun startStop() {
        if (timerStatus == TimerStatus.STOPPED) {

            // call to initialize the timer values
            setTimerValues()
            // call to initialize the progress bar values
            setProgressBarValue()
            // showing the reset icon

            // changing the timer status to started
            timerStatus = TimerStatus.STARTED
            // call to start the count down timer
            startCountdownTimer()
            //buttonStart.text = "Reset"

        } else {


            // changing the timer status to stopped
            timerStatus = TimerStatus.STOPPED

            reset()



        }
    }

    private fun setTimerValues() {
        var time = 1
        // assigning values after converting to milliseconds
        timeCountInMilliSeconds = (time * 10 * 1000).toLong()
    }
}
