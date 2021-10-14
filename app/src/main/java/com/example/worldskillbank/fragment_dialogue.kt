package com.example.worldskillbank

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.worldskillbank.databinding.FragmentDialogueBinding


class fragment_dialogue : Fragment() {

    lateinit var binding: FragmentDialogueBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDialogueBinding.inflate(layoutInflater)

        if(binding.editTextTextPersonName.text.toString().isEmpty()){

            binding.textUsers.append("\n")
            binding.textUsers.append(binding.button.text.toString())

        }



        return inflater.inflate(R.layout.fragment_dialogue, container, false)
    }
}