package com.example.worldskillbank

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.example.worldskillbank.databinding.FragmentExchangeRatesBinding

class ExchangeRates : Fragment() {

    lateinit var binding: FragmentExchangeRatesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentExchangeRatesBinding.inflate(layoutInflater)

        (activity as AppCompatActivity).supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        (activity as AppCompatActivity).supportActionBar!!.title = "Курсы валют"
        setHasOptionsMenu(true)

        return inflater.inflate(R.layout.fragment_exchange_rates, container, false)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        val id = item.itemId
        when (id)
        {
            android.R.id.home -> view?.findNavController()?.navigate(R.id.navigation_home)

        }
        return super.onOptionsItemSelected(item)
    }

}