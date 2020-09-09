package com.martiandeveloper.exchangerate.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.martiandeveloper.exchangerate.R
import com.martiandeveloper.exchangerate.model.ExchangeRate
import kotlinx.android.synthetic.main.recyclerview_rate_item.view.*

class RecyclerViewExchangeAdapter(
    private val exchangeList: ArrayList<ExchangeRate>,
    private val listener: Listener
) : RecyclerView.Adapter<RecyclerViewExchangeAdapter.RecyclerViewExchangeViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerViewExchangeViewHolder {
        return RecyclerViewExchangeViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recyclerview_rate_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerViewExchangeViewHolder, position: Int) {
        holder.bind(exchangeList[position], listener)
    }

    override fun getItemCount(): Int {
        return exchangeList.count()
    }

    class RecyclerViewExchangeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(exchangeRate: ExchangeRate, listener: Listener) {
            itemView.recyclerview_rate_item_codeMTV.text = exchangeRate.code

            if (exchangeRate.rate != null) {
                itemView.recyclerview_rate_item_rateMTV.text = "${exchangeRate.rate}"
            } else {
                itemView.recyclerview_rate_item_rateMTV.text =
                    itemView.resources.getString(R.string.base)
            }

            itemView.setOnClickListener {
                listener.onItemClick(exchangeRate)
            }
        }

    }

    interface Listener {
        fun onItemClick(exchangeRate: ExchangeRate)
    }
}
