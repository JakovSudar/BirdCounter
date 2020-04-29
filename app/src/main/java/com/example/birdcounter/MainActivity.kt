package com.example.birdcounter

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val preferenceManager = PreferenceManager()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpUi()
    }

    private fun setUpUi() {

        refreshScreen()
        buttonBlue.setOnClickListener{countBird("#0000FF")}
        buttonOrange.setOnClickListener{countBird("#FFA500")}
        buttonRed.setOnClickListener{countBird("#FF0000")}
        buttonWhite.setOnClickListener{countBird("#ffffff")}
        buttonReset.setOnClickListener{resetAll()}
    }

    private fun resetAll() {
        preferenceManager.saveColor("#ffffff")
        preferenceManager.saveCounter(0)
        refreshScreen()
    }

    private fun refreshScreen() {
        val preferenceManager = PreferenceManager()
        val current = preferenceManager.retriveCounter()
        val color = preferenceManager.retriveColor()
        layout.setBackgroundColor(Color.parseColor(color))
        tv_counter.setText(""+current)
        preferenceManager.saveCounter(current)
    }

    private fun countBird(color: String) {
        preferenceManager.incrementBirdCounter()
        preferenceManager.saveColor(color)
        refreshScreen()
    }

}
