package com.example.worldskillbank.adapter_RV

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.worldskillbank.R
import com.example.worldskillbank.data_history_RV.bank_cards
import com.example.worldskillbank.databinding.BankCardsRvBinding

class adapter_cards: RecyclerView.Adapter<adapter_cards.CardHolder>() {

    val CardList = ArrayList<bank_cards>()

    class CardHolder(item: View): RecyclerView.ViewHolder(item) {

        var binding = BankCardsRvBinding.bind(item)

        fun bind(card: bank_cards) = with(binding){

            Balance.text = card.Balance.toString()
            cardName.text = card.Name_card
            cardNumber.text = card.Card_number
        }

    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.bank_cards_rv, parent, false)

        return CardHolder(view)
    }



    override fun onBindViewHolder(holder: CardHolder, position: Int) {

        holder.bind(CardList[position])
    }



    override fun getItemCount(): Int {

        return CardList.size
    }

    fun addCard(card:bank_cards){

        CardList.add(card)
        notifyDataSetChanged()
    }

}