package com.example.worldskillbank

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import com.example.worldskillbank.databinding.ActivityExchangeRatesBinding

class exchange_rates : AppCompatActivity() {

    lateinit var binding: ActivityExchangeRatesBinding

    var ActionBar:ActionBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exchange_rates)

        binding = ActivityExchangeRatesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ActionBar = supportActionBar

        ActionBar?.title = "Курсы валют"
        ActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        val id = item.itemId
        when (id)
        {
            android.R.id.home -> {

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }

        }
        return super.onOptionsItemSelected(item)
    }
}