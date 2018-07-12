package com.example.mayank.testapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.*
import java.util.concurrent.TimeUnit


class SampleCountdownTimer : AppCompatActivity(), View.OnClickListener {


    private var timeCountInMilliSeconds = (1 * 60000).toLong()

    private var timerStatus = TimerStatus.STOPPED

    private var progressBarCircle: ProgressBar? = null
    private var editTextMinute: EditText? = null
    private var textViewTime: TextView? = null
    private var imageViewReset: ImageView? = null
    private var imageViewStartStop: ImageView? = null
    private var countDownTimer: CountDownTimer? = null

    private enum class TimerStatus {
        STARTED,
        STOPPED
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample_countdown_timer)

        // method call to initialize the views
        initViews()
        // method call to initialize the listeners
        initListeners()


    }

    /**
     * method to initialize the views
     */
    private fun initViews() {
        progressBarCircle = findViewById<View>(R.id.progressBarCircle) as ProgressBar?
        editTextMinute = findViewById<View>(R.id.editTextMinute) as EditText?
        textViewTime = findViewById<View>(R.id.textViewTime) as TextView?
        imageViewReset = findViewById<ImageView>(R.id.imageViewReset)
        imageViewStartStop = findViewById<ImageView>(R.id.imageViewStartStop)
    }

    /**
     * method to initialize the click listeners
     */
    private fun initListeners() {
        imageViewReset?.setOnClickListener(this)
        imageViewStartStop?.setOnClickListener(this)
    }

    /**
     * implemented method to listen clicks
     *
     * @param view
     */
    override fun onClick(view: View) {
        when (view.getId()) {
            R.id.imageViewReset -> reset()
            R.id.imageViewStartStop -> startStop()
        }
    }

    /**
     * method to reset count down timer
     */
    private fun reset() {
        stopCountDownTimer()
        startCountDownTimer()
    }


    /**
     * method to start and stop count down timer
     */
    private fun startStop() {
        if (timerStatus == TimerStatus.STOPPED) {

            // call to initialize the timer values
            setTimerValues()
            // call to initialize the progress bar values
            setProgressBarValues()
            // showing the reset icon
            imageViewReset!!.setVisibility(View.VISIBLE)
            // changing play icon to stop icon
            imageViewStartStop!!.setImageResource(R.mipmap.ic_reset)
            // making edit text not editable
            editTextMinute!!.isEnabled = false
            // changing the timer status to started
            timerStatus = TimerStatus.STARTED
            // call to start the count down timer
            startCountDownTimer()

        } else {

            // hiding the reset icon
            imageViewReset!!.setVisibility(View.GONE)
            // changing stop icon to start icon
            imageViewStartStop!!.setImageResource(R.mipmap.ic_start)
            // making edit text editable
            editTextMinute!!.isEnabled = true
            // changing the timer status to stopped
            timerStatus = TimerStatus.STOPPED
            stopCountDownTimer()

        }

    }

    /**
     * method to initialize the values for count down timer
     */
    private fun setTimerValues() {
        var time = 0
        if (!editTextMinute!!.text.toString().isEmpty()) {
            // fetching value from edit text and type cast to integer
            time = Integer.parseInt(editTextMinute!!.text.toString().trim { it <= ' ' })
        } else {
            // toast message to fill edit text
            Toast.makeText(applicationContext, getString(R.string.message_minutes), Toast.LENGTH_LONG).show()
        }
        // assigning values after converting to milliseconds
        timeCountInMilliSeconds = (time * 60 * 1000).toLong()
    }

    /**
     * method to start count down timer
     */
    private fun startCountDownTimer() {

        countDownTimer = object : CountDownTimer(timeCountInMilliSeconds, 1000) {
            override fun onTick(millisUntilFinished: Long) {

//                textViewTime!!.text = hmsTimeFormatter(millisUntilFinished)
                textViewTime!!.text = secondsFormatter(millisUntilFinished)
                progressBarCircle!!.progress = (millisUntilFinished / 1000).toInt()

            }

            override fun onFinish() {

//                textViewTime!!.text = hmsTimeFormatter(timeCountInMilliSeconds)
                textViewTime!!.text = secondsFormatter(timeCountInMilliSeconds)
                // call to initialize the progress bar values
                setProgressBarValues()
                // hiding the reset icon
                imageViewReset!!.visibility = View.GONE
                // changing stop icon to start icon
                imageViewStartStop!!.setImageResource(R.mipmap.ic_start)
                // making edit text editable
                editTextMinute!!.isEnabled = true
                // changing the timer status to stopped
                timerStatus = TimerStatus.STOPPED
            }

        }.start()
        countDownTimer!!.start()
    }

    /**
     * method to stop count down timer
     */
    private fun stopCountDownTimer() {
        countDownTimer!!.cancel()
    }

    /**
     * method to set circular progress bar values
     */
    private fun setProgressBarValues() {

        progressBarCircle!!.max = timeCountInMilliSeconds.toInt() / 1000
        progressBarCircle!!.progress = timeCountInMilliSeconds.toInt() / 1000
    }


    /**
     * method to convert millisecond to time format
     *
     * @param milliSeconds
     * @return HH:mm:ss time formatted string
     */
    private fun hmsTimeFormatter(milliSeconds: Long): String {

        return String.format("%02d:%02d:%02d",
                TimeUnit.MILLISECONDS.toHours(milliSeconds),
                TimeUnit.MILLISECONDS.toMinutes(milliSeconds) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(milliSeconds)),
                TimeUnit.MILLISECONDS.toSeconds(milliSeconds) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(milliSeconds)))


    }

    private fun secondsFormatter(milliSeconds: Long): String {
        return String.format("%02d", TimeUnit.MILLISECONDS.toSeconds(milliSeconds) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(milliSeconds)))
    }


}