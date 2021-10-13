package com.example.worldskillbank

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBar
import com.example.worldskillbank.databinding.FragmentNotifications2Binding


    lateinit var binding: FragmentNotifications2Binding
class Notifications : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentNotifications2Binding.inflate(layoutInflater)

        return inflater.inflate(R.layout.fragment_notifications2, container, false)
    }

}