package com.example.worldskillbank.ui.home

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.graphics.Color
import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.worldskillbank.R
import com.example.worldskillbank.adapter_RV.adapter_cards
import com.example.worldskillbank.data_history_RV.bank_cards
import com.example.worldskillbank.databinding.*

class HomeFragment : Fragment() {

    val recyclerView: RecyclerView? = null
    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    lateinit var binding_1: BankCardsRvBinding

    var nameList = ArrayList<String>()

    var bool:Boolean = true

    var result:Float = 0f

    private val adapter = adapter_cards()


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

        binding_1 = BankCardsRvBinding.inflate(layoutInflater)

        (activity as AppCompatActivity).supportActionBar!!.setDisplayHomeAsUpEnabled(false)
        (activity as AppCompatActivity).supportActionBar!!.title = "Главная"

        setHasOptionsMenu(true)

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
                2-> view.findNavController().navigate(R.id.branchesAndATMs)
                1-> view.findNavController().navigate(R.id.exchangeRates2)
            }
            nameList.clear()

        }

        binding.constraintLayout.setOnClickListener {

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
                        binding_1.cardName.text = user_text.text.toString()
                        dialog.dismiss()
                    }
                }else{
                    dialog.dismiss()
                }
            }
            dialog.setCancelable(true)
            dialog.window?.setBackgroundDrawableResource(R.drawable.krujok)
        }


        binding.newCard.setOnClickListener {

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
                        dialog.dismiss()

                        binding.RV.layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false)

                        binding.RV.adapter = adapter

                        val rand_sum = (1000..50000).random()

                        val Card_number = (1..9).random().toString()
                        val Card_number_1 = (1..9).random().toString()
                        val Card_number_2 = (1..9).random().toString()
                        val Card_number_3 = (1..9).random().toString()
                        val Card_number_4 = (1..9).random().toString()
                        val Card_number_5 = (1..9).random().toString()
                        val Card_number_6 = (1..9).random().toString()
                        val Card_number_7 = (1..9).random().toString()
                        val Card_number_8 = (1..9).random().toString()
                        val Card_number_9 = (1..9).random().toString()
                        val Card_number_10 = (1..9).random().toString()
                        val Card_number_11 = (1..9).random().toString()
                        val Card_number_12 = (1..9).random().toString()
                        val Card_number_13 = (1..9).random().toString()
                        val Card_number_14 = (1..9).random().toString()

                        val Card_number_results = Card_number+Card_number_1+Card_number_2+Card_number_3+Card_number_4+Card_number_5+Card_number_6+
                                Card_number_7+Card_number_8+Card_number_9+Card_number_10+Card_number_11+Card_number_12+Card_number_13+Card_number_14

                        val card = bank_cards(rand_sum,Card_number_results,user_text.text.toString())

                        adapter.addCard(card)

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

                binding_1.informationcard.text = "Карта заблокирована"
                binding_1.informationcard.setTextColor(Color.RED)
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
                        result = text_users_1.text.toString().toFloat() / 100

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
                    if (text_users_1.text.toString().isNotEmpty()) {

                        result = text_users_1.text.toString().toFloat() / 100

                        if (result <=30)
                        {
                            result = 30f
                        }else if (result >=500){
                            result = 500f
                        }else{
                            result = text_users_1.text.toString().toFloat() / 100
                        }

                        val dialogBuilder_2 = AlertDialog.Builder(this.context)
                        val bindingChange_2 = AbroadCamuDialogBinding.inflate(inflater)
                        dialogBuilder_2.setView(bindingChange_2.root)

                        val dialog_2: AlertDialog = dialogBuilder_2.show()

                        val cancellation = dialog_2.findViewById<Button>(R.id.cancellation)
                        val Proceed_BUT = dialog_2.findViewById<Button>(R.id.Proceed_BUT)

                        cancellation.setOnClickListener {
                            dialog_2.dismiss()
                        }
                        Proceed_BUT.setOnClickListener {
                            dialog_2.dismiss()
                            dialog_1.dismiss()
                            dialog.dismiss()

                            val Balance:Float = binding_1.Balance.text.toString().toFloat() - result
                            binding_1.Balance.text = Balance.toString()
                        }

                        dialog_2.setCancelable(false)
                        dialog_2.window?.setBackgroundDrawableResource(R.drawable.krujok)
                    }

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

        binding.NV.setNavigationItemSelectedListener {

            when(it.itemId)
            {
                R.id.Notifications_menu -> view?.findNavController()?.navigate(R.id.notifications_1)
                R.id.settings -> view?.findNavController()?.navigate(R.id.settings2)
                R.id.account -> view?.findNavController()?.navigate(R.id.my_account_Fragment)
            }
            true
        }

        return root

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
            R.id.menu -> binding.DL.openDrawer(GravityCompat.START)
        }
        return super.onOptionsItemSelected(item)
    }

}
