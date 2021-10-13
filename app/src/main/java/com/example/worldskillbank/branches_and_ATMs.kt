package com.example.worldskillbank

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar

class branches_and_ATMs : AppCompatActivity() {

    var actBar: ActionBar? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_branches_and_atms)

        actBar = supportActionBar
        actBar?.hide()
    }
}