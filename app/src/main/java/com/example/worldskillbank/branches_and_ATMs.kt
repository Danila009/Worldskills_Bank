package com.example.worldskillbank

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.navigation.findNavController
import com.example.worldskillbank.databinding.ActivityBranchesAndAtmsBinding
import java.util.zip.Inflater

class branches_and_ATMs : AppCompatActivity() {

    lateinit var binding: ActivityBranchesAndAtmsBinding
    var actBar: ActionBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_branches_and_atms)

        binding = ActivityBranchesAndAtmsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        actBar = supportActionBar

        actBar?.setDisplayHomeAsUpEnabled(true)
        actBar?.title = "Отделения и банкоматыт"
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