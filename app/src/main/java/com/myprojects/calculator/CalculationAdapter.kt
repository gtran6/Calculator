package com.myprojects.calculator

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CalculationAdapter(private val calculations: List<ViewModel.Calculation>) :
    RecyclerView.Adapter<CalculationAdapter.CalculationViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalculationViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_calculation, parent, false)
        return CalculationViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return calculations.size
    }

    override fun onBindViewHolder(holder: CalculationViewHolder, position: Int) {
        val calculation = calculations[position]
        holder.inputTextView.text = calculation.input
        holder.totalTextView.text = calculation.output
    }
    class CalculationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val inputTextView: TextView = itemView.findViewById(R.id.txtInput)
        val totalTextView: TextView = itemView.findViewById(R.id.txtTotal)
    }
}