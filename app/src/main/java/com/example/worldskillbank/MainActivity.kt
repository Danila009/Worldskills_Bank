package com.example.worldskillbank

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.worldskillbank.databinding.ActivityMainBinding
import com.example.worldskillbank.db.MuDbManager
import com.example.worldskillbank.table.new_card
import com.google.android.material.button.MaterialButton
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import yanzhikai.textpath.SyncTextPathView





class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var actBar: ActionBar? = null

    var tpv: SyncTextPathView? = null


    val myDbManager = MuDbManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val database = Firebase.database
        val myRef = database.getReference("test")

        myRef.setValue("Hello, World!")

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myDbManager.openDb()

        actBar = supportActionBar
        actBar?.hide()


        binding.nameBank.startAnimation(1F, 0F)




        binding.exchangeRates.setOnClickListener{
            val intent = Intent(this, exchange_rates::class.java)
            startActivity(intent)
        }
        binding.branchesAndATMs.setOnClickListener {
            val intent = Intent(this, branches_and_ATMs::class.java)
            startActivity(intent)
        }

        binding.entrance.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            val inflater = layoutInflater
            val dialogLayout = inflater.inflate(R.layout.entrance_design_dialog, null)

            val Btn_entrance = dialogLayout?.findViewById(R.id.entrance) as Button
            val Btn_registration = dialogLayout.findViewById(R.id.registration_but) as Button
            val cancellation_1 = dialogLayout.findViewById<Button>(R.id.cancellation_1)


            builder.setView(dialogLayout)
            Btn_entrance.setOnClickListener {

                val intent = Intent(this, Main_screen::class.java)
                startActivity(intent)

            }
            Btn_registration.setOnClickListener {

                registration()
            }
            val dialog: AlertDialog = builder.show()
            dialog.setCancelable(false)
            cancellation_1.setOnClickListener {
                dialog.dismiss()
            }
            dialog.window?.setBackgroundDrawableResource(R.drawable.krujok)
        }
    }



    @SuppressLint("SetTextI18n")
    fun registration(){
        val builder = AlertDialog.Builder(this)
        val inflater = layoutInflater
        val dialogLayout = inflater.inflate(R.layout.registration, null)
        val Btn_entrance = dialogLayout?.findViewById(R.id.registration_but_1) as Button
        val login = dialogLayout.findViewById(R.id.login) as TextView
        val password = dialogLayout.findViewById(R.id.password) as TextView
        val password_1 = dialogLayout.findViewById(R.id.password_1) as TextView
        val email = dialogLayout.findViewById<TextView>(R.id.email)
        val text = dialogLayout.findViewById<TextView>(R.id.textView2)
        val cancellation = dialogLayout.findViewById<TextView>(R.id.cancellation)

        Btn_entrance.setOnClickListener {


            if(login.text.toString().isEmpty() and password.text.toString().isEmpty() and password_1.text.toString().isEmpty() and email.text.toString().isEmpty()){
                text.text = "Зваполните все поля"
            }else {
                if (login.text.toString().count() < 6){
                    text.text = "Логин должен состоять из 6 или больше символов"
                } else if (password.text.toString().count() < 8){
                    text.text = "Пароль слишком короткий"
                }else if (password.text.toString() != password_1.text.toString()){
                    text.text = "Пароль не совпадает"
                }else if (email.text.toString().count() < 6 ){
                    text.text = "Email слишком короткий"
                } else if (!email.text.toString().any("." :: contains) and  !email.text.toString().any("@" :: contains)) {
                    text.text = "Email введён не коректно"
                }else {

                    val rand_sum = (1000..50000).random()
                    val rand_per_day = (1000..10000).random()

                    var i =0
                    var Card_number = ""

                    while (i<12)
                    {
                        val Card_number_09 = (1..9).random()
                        Card_number += Card_number_09.toString()
                        i++
                    }

                    val intent = Intent(this, Main_screen::class.java)
                    startActivity(intent)

                    myDbManager.insertToDb(rand_sum.toString(), password.text.toString(),email.text.toString(), login.text.toString(), rand_per_day.toString(),
                        Card_number)
                }
            }
        }
        builder.setView(dialogLayout)

        val dialog: AlertDialog = builder.show()
        dialog.setCancelable(false)
        dialog.window?.setBackgroundDrawableResource(R.drawable.krujok)

        cancellation.setOnClickListener {
            dialog.dismiss()
        }
    }
}
