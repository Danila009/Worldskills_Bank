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


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var actBar: ActionBar? = null

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



        val anim = AnimationUtils.loadAnimation(this,R.anim.amim_text)

        binding.name.startAnimation(anim)


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


                    val intent = Intent(this, Main_screen::class.java)
                    startActivity(intent)

                    myDbManager.insertToDb(rand_sum.toString(), password.text.toString(),email.text.toString(), login.text.toString(), rand_per_day.toString(),
                        Card_number_results)
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
