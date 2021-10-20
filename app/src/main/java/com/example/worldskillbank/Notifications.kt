package com.example.worldskillbank

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.example.worldskillbank.R.id.navigation_home
import com.example.worldskillbank.databinding.FragmentNotifications2Binding


    lateinit var binding: FragmentNotifications2Binding

class Notifications : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentNotifications2Binding.inflate(layoutInflater)

        (activity as AppCompatActivity).supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        (activity as AppCompatActivity).supportActionBar!!.title = "Уведомления"

        setHasOptionsMenu(true)

        return inflater.inflate(R.layout.fragment_notifications2, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater)
    {
        inflater.inflate(R.menu.notifications_menu, menu);
        super.onCreateOptionsMenu(menu,inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        val id = item.itemId
        when (id)
        {
            android.R.id.home -> view?.findNavController()?.navigate(R.id.navigation_home)
            R.id.all -> Toast.makeText(activity, "Sort", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }

}