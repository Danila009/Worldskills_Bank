package com.example.worldskillbank

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.findNavController
import com.example.worldskillbank.databinding.FragmentMyAccountBinding


class my_account_Fragment : Fragment() {

    lateinit var binding: FragmentMyAccountBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMyAccountBinding.inflate(layoutInflater)

        (activity as AppCompatActivity).supportActionBar!!.title = "Мой аккаунт"
        //(activity as AppCompatActivity).supportActionBar!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#1B811D")))

        (activity as AppCompatActivity).supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        setHasOptionsMenu(true)

        binding.NV.setNavigationItemSelectedListener {

            when(it.itemId)
            {
                R.id.Notifications_menu -> view?.findNavController()?.navigate(R.id.notifications_1)
                R.id.settings -> view?.findNavController()?.navigate(R.id.settings2)
                R.id.account -> view?.findNavController()?.navigate(R.id.my_account_Fragment)
            }
            true
        }

        return inflater.inflate(R.layout.fragment_my_account_, container, false)
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
            android.R.id.home -> view?.findNavController()?.navigate(R.id.navigation_home)
            R.id.menu -> binding.DravL.openDrawer(GravityCompat.START)

        }
        return super.onOptionsItemSelected(item)
    }

}