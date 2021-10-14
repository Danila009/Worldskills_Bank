package com.example.worldskillbank.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.worldskillbank.R
import com.example.worldskillbank.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    private var _binding: FragmentDashboardBinding? = null

    var TranslateList = ArrayList<String>()
    var PayList = ArrayList<String>()

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        TranslateList.add("Другому человеку")
        TranslateList.add("Между своими")
        TranslateList.add("За рубеж")

        PayList.add("Мобильная связь")
        PayList.add("Образование")
        PayList.add("Транспорт")
        PayList.add("Эдоровье")
        PayList.add("Дом")
        PayList.add("Работа и бизнес")
        PayList.add("Государство")
        PayList.add("Отдых и развличения")


        binding.listTranslate.adapter = ArrayAdapter(
            requireActivity().applicationContext,
            R.layout.text_color_white, TranslateList
        )

        binding.listPay.adapter = ArrayAdapter(
            requireActivity().applicationContext,
            R.layout.text_color_white, PayList
        )

        return root
    }
}