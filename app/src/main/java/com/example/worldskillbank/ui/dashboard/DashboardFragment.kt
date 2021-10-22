package com.example.worldskillbank.ui.dashboard

import android.os.Bundle
import android.view.*
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
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

        (activity as AppCompatActivity).supportActionBar!!.setDisplayHomeAsUpEnabled(false)
        setHasOptionsMenu(true)

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