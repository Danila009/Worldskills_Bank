package com.example.worldskillbank.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.worldskillbank.MainActivity
import com.example.worldskillbank.R
import com.example.worldskillbank.branches_and_ATMs
import com.example.worldskillbank.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    val recyclerView: RecyclerView? = null
    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    var nameList = ArrayList<String>()

    var bool:Boolean = true


    private val binding get() = _binding!!

    override fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        homeViewModel.text.observe(viewLifecycleOwner, Observer {
        })

        nameList.add("Аналис расходов")
        nameList.add("Курс валют и металлов")
        nameList.add("Отделения и банкоматы")
        nameList.add("Уведомления")
        nameList.add("Сервисы")
        nameList.add("Страхование")
        nameList.add("Кредиты")
        nameList.add("Инвестиции")

        //val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1, nameList)

        //binding.list.adapter = adapter

        binding.list.adapter = ArrayAdapter(
            requireActivity().applicationContext,
            R.layout.text_color_white, nameList

        )


        binding.list.setOnItemClickListener { adapterView, view, i, l ->

            when(i)
            {
                3-> view.findNavController().navigate(R.id.notifications_1)
                2-> view.findNavController().navigate(R.id.branches_and_ATMs2)
                1-> view.findNavController().navigate(R.id.exchange_rates)
            }
            nameList.clear()

        }

        binding.button2222.setOnClickListener {

        }
        binding.card.setOnClickListener {

            if(bool){
                binding.button2222.visibility = View.VISIBLE
                binding.button7.visibility = View.VISIBLE
                binding.button8.visibility = View.VISIBLE
                binding.button9.visibility = View.VISIBLE
                binding.button.visibility = View.VISIBLE
                binding.list.visibility = View.INVISIBLE
                bool = false
            }else if (!bool){
                binding.button2222.visibility = View.INVISIBLE
                binding.button7.visibility = View.INVISIBLE
                binding.button8.visibility = View.INVISIBLE
                binding.button9.visibility = View.INVISIBLE
                binding.button.visibility = View.INVISIBLE
                binding.list.visibility = View.VISIBLE
                bool = true
            }
        }
        return root
    }
}