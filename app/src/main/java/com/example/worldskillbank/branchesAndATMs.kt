package com.example.worldskillbank

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.example.worldskillbank.databinding.FragmentBranchesAndATMsBinding


class branchesAndATMs : Fragment() {

    lateinit var binding: FragmentBranchesAndATMsBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentBranchesAndATMsBinding.inflate(layoutInflater)

        (activity as AppCompatActivity).supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        (activity as AppCompatActivity).supportActionBar!!.title = "Отделения и банкоматыт"
        setHasOptionsMenu(true)

        return inflater.inflate(R.layout.fragment_branches_and_a_t_ms, container, false)
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