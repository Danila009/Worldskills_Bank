package com.example.worldskillbank.table

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.worldskillbank.R


class new_card(private val names: List<String>) :
    RecyclerView.Adapter<new_card.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var ConstraintLayout_1: ConstraintLayout? = null
        var ConstraintLayout_new: ConstraintLayout? = null

        init {
            ConstraintLayout_1 = itemView.findViewById(R.id.card)
            ConstraintLayout_new = itemView.findViewById(R.id.card_new)

        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.now_card, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

    }

    override fun getItemCount() = names.size


}