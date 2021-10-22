package com.example.worldskillbank

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity


class my_account_Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        (activity as AppCompatActivity).supportActionBar!!.setDisplayHomeAsUpEnabled(false)
        (activity as AppCompatActivity).supportActionBar!!.title = "Мой аккаунт"
        //(activity as AppCompatActivity).supportActionBar!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#1B811D")))

        setHasOptionsMenu(true)

        return inflater.inflate(R.layout.fragment_my_account_, container, false)
    }

}