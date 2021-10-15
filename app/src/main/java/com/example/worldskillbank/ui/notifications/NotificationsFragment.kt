package com.example.worldskillbank.ui.notifications

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.worldskillbank.R
import com.example.worldskillbank.databinding.ChangeDialogBinding
import com.example.worldskillbank.databinding.FragmentNotificationsBinding

class NotificationsFragment : Fragment() {

    private lateinit var notificationsViewModel: NotificationsViewModel
    private var _binding: FragmentNotificationsBinding? = null

    private val binding get() = _binding!!

    @SuppressLint("InflateParams", "SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        notificationsViewModel =
            ViewModelProvider(this).get(NotificationsViewModel::class.java)

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.RLProfress.setOnClickListener {

            val dialogBuilder = AlertDialog.Builder(this.context)
            val bindingChange = ChangeDialogBinding.inflate(inflater)
            dialogBuilder.setView(bindingChange.root)

            val dialog: AlertDialog = dialogBuilder.show()

            val dialogue_continue = dialog.findViewById<Button>(R.id.dialogue_continue)
            val text_max_pog = dialog.findViewById<TextView>(R.id.editTextNumber)
            val text_inf = dialog.findViewById<TextView>(R.id.textInf)

            dialogue_continue.setOnClickListener {

                if (text_max_pog.text.toString().isNotEmpty())
                {
                    if (text_max_pog.text.toString().count() in 1..10){

                        binding.progressBar.max = text_max_pog.text.toString().toInt()
                        binding.textRubles.text = "${binding.progressBar.max.toString()} P"
                        dialog.dismiss()
                    }else{
                        text_inf.text = "Число слишком большое"
                        text_inf.setTextColor(Color.RED)
                        text_inf.textSize = 14F
                    }

                }else{
                    dialog.dismiss()
                }
            }

            dialog.setCancelable(true)

            dialog.window?.setBackgroundDrawableResource(R.drawable.krujok)
        }

        return root
    }

}