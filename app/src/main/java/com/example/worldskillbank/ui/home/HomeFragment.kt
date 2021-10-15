package com.example.worldskillbank.ui.home

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.worldskillbank.R
import com.example.worldskillbank.databinding.*

class HomeFragment : Fragment() {

    val recyclerView: RecyclerView? = null
    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    var nameList = ArrayList<String>()

    var bool:Boolean = true


    private val binding get() = _binding!!

    @SuppressLint("SetTextI18n")
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

        binding.card.setOnClickListener {

            if(bool){
                binding.TranslateBut.visibility = View.VISIBLE
                binding.Rename.visibility = View.VISIBLE
                binding.button8.visibility = View.VISIBLE
                binding.BlockBut.visibility = View.VISIBLE
                binding.button.visibility = View.VISIBLE
                binding.list.visibility = View.INVISIBLE
                bool = false
            }else if (!bool){
                binding.TranslateBut.visibility = View.INVISIBLE
                binding.Rename.visibility = View.INVISIBLE
                binding.button8.visibility = View.INVISIBLE
                binding.BlockBut.visibility = View.INVISIBLE
                binding.button.visibility = View.INVISIBLE
                binding.list.visibility = View.VISIBLE
                bool = true
            }
        }

        binding.Rename.setOnClickListener {

            val dialogBuilder = AlertDialog.Builder(this.context)
            val bindingChange = RenameDialogBinding.inflate(inflater)
            dialogBuilder.setView(bindingChange.root)

            val dialog: AlertDialog = dialogBuilder.show()

            val but_proceed = dialog.findViewById<Button>(R.id.but_proceed)
            val user_text = dialog.findViewById<TextView>(R.id.user_text)
            val text_inf = dialog.findViewById<TextView>(R.id.textInf_1)

            but_proceed.setOnClickListener {

                if (user_text.text.toString().isNotEmpty()){

                    if (user_text.text.toString().count() < 3 ){

                        text_inf.text = "Название должно состоять из трех или больше символов"
                        text_inf.setTextColor(Color.RED)
                        text_inf.textSize = 14F
                    }else
                    {
                        binding.cardName.text = user_text.text.toString()
                        dialog.dismiss()
                    }
                }else{
                    dialog.dismiss()
                }
            }
            dialog.setCancelable(true)
            dialog.window?.setBackgroundDrawableResource(R.drawable.krujok)
        }

        binding.BlockBut.setOnClickListener {

            val dialogBuilder = AlertDialog.Builder(this.context)
            val bindingChange = BlockDialogBinding.inflate(inflater)
            dialogBuilder.setView(bindingChange.root)

            val dialog: AlertDialog = dialogBuilder.show()

            val But_proceed = dialog.findViewById<Button>(R.id.But_proceed)
            val But_cancellation = dialog.findViewById<Button>(R.id.cancellation)

            But_proceed.setOnClickListener {

                binding.informationcard.text = "Карта заблокирована"
                binding.informationcard.setTextColor(Color.RED)
                dialog.dismiss()
            }

            But_cancellation.setOnClickListener {
                dialog.dismiss()
            }

            dialog.setCancelable(false)
            dialog.window?.setBackgroundDrawableResource(R.drawable.krujok)
        }

        binding.TranslateBut.setOnClickListener {

            val dialogBuilder = AlertDialog.Builder(this.context)
            val bindingChange = TranslateDialogBinding.inflate(inflater)
            dialogBuilder.setView(bindingChange.root)

            val dialog: AlertDialog = dialogBuilder.show()
            val Cancellation_but = dialog.findViewById<Button>(R.id.Cancellation_but)
            val Abroad_but = dialog.findViewById<Button>(R.id.Abroad_but)
            val Between_their_but = dialog.findViewById<Button>(R.id.Between_their_but)
            val To_another_person_but = dialog.findViewById<Button>(R.id.To_another_person_but)


            Cancellation_but.setOnClickListener {
                dialog.dismiss()
            }
            Abroad_but.setOnClickListener {

                val dialogBuilder_1 = AlertDialog.Builder(this.context)
                val bindingChange_1 = AbroadDialogBinding.inflate(inflater)
                dialogBuilder_1.setView(bindingChange_1.root)

                val dialog_1: AlertDialog = dialogBuilder_1.show()

                val Proceed_but_1 = dialog_1.findViewById<Button>(R.id.Proceed_but_1)
                val commission_text = dialog_1.findViewById<Button>(R.id.commission_text_11)

                val text_users_1 = dialog_1.findViewById<TextView>(R.id.text_users_1)
                val cancellation_but = dialog_1.findViewById<Button>(R.id.cancellation_but)

                val text11 = dialog_1.findViewById<TextView>(R.id.text11)

                commission_text.setOnClickListener {

                    if (text_users_1.text.toString().isNotEmpty()){
                        val result:Float = text_users_1.text.toString().toFloat() / 100

                        if (result <=30)
                        {
                            text11.text = "Комиссия 30 рублей"
                        }else if (result >=500){
                            text11.text = "Комиссия 500 рублей"
                        }else{
                            text11.text = "Комиссия ${result.toString()} рублей"
                        }

                    }

                }

                Proceed_but_1.setOnClickListener {

                        val dialogBuilder_2 = AlertDialog.Builder(this.context)
                        val bindingChange_2 = AbroadCamuDialogBinding.inflate(inflater)
                        dialogBuilder_2.setView(bindingChange_2.root)

                        val dialog_2: AlertDialog = dialogBuilder_2.show()

                        val cancellation = dialog_1.findViewById<Button>(R.id.cancellation)

                        cancellation.setOnClickListener {
                            dialog_2.dismiss()
                        }

                        dialog_2.setCancelable(false)
                        dialog_2.window?.setBackgroundDrawableResource(R.drawable.krujok)

                }

                cancellation_but.setOnClickListener {
                    dialog_1.dismiss()
                }


                dialog_1.setCancelable(false)
                dialog_1.window?.setBackgroundDrawableResource(R.drawable.krujok)
            }

            Between_their_but.setOnClickListener {
                val dialogBuilder_3 = AlertDialog.Builder(this.context)
                val bindingChange_3 = BetweenTheirDialogBinding.inflate(inflater)
                dialogBuilder_3.setView(bindingChange_3.root)
                val dialog_3: AlertDialog = dialogBuilder_3.show()
                dialog_3.setCancelable(true)
                dialog_3.window?.setBackgroundDrawableResource(R.drawable.krujok)

            }

            dialog.setCancelable(false)
            dialog.window?.setBackgroundDrawableResource(R.drawable.krujok)

        }
        return root

    }
}
