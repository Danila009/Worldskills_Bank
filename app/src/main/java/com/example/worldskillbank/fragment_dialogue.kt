package com.example.worldskillbank

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.example.worldskillbank.databinding.FragmentDialogueBinding


class fragment_dialogue : Fragment() {

    lateinit var binding: FragmentDialogueBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDialogueBinding.inflate(layoutInflater)

        (activity as AppCompatActivity).supportActionBar!!.setDisplayHomeAsUpEnabled(false)
        (activity as AppCompatActivity).supportActionBar!!.title = "Главная"

        setHasOptionsMenu(true)

        binding.apply {
            button2.setOnClickListener {

                drawer.openDrawer(GravityCompat.START)
            }
        }

        return inflater.inflate(R.layout.fragment_dialogue, container, false)
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater)
    {
        inflater.inflate(R.menu.home_menu, menu);
        super.onCreateOptionsMenu(menu,inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        val id = item.itemId
        when (id)
        {

        }
        return super.onOptionsItemSelected(item)
    }
}