package com.example.worldskillbank

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.example.worldskillbank.databinding.FragmentSettingsBinding

class settings : Fragment() {

    lateinit var binding: FragmentSettingsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSettingsBinding.inflate(layoutInflater)

        (activity as AppCompatActivity).supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        (activity as AppCompatActivity).supportActionBar!!.title = "Настройки"

        setHasOptionsMenu(true)

        binding.DeleteHistory.setOnClickListener {

            view?.findNavController()?.navigate(R.id.mainActivity)
        }

        return inflater.inflate(R.layout.fragment_settings, container, false)
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