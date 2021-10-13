package com.example.worldskillbank

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar

class exchange_rates : AppCompatActivity() {
    var actBar: ActionBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exchange_rates)

        actBar = supportActionBar
        actBar?.hide()
    }
}