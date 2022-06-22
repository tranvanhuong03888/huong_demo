package com.example.test.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.test.R
import com.example.test.`interface`.IClickListener
import com.example.test.model.MonthModel
import kotlinx.android.synthetic.main.item_bottom_sheet.view.*


class BottomSheetAdapter(
    private val context: Context,
    private val List: List<MonthModel>,
    private val itemIClickListener: IClickListener
) : RecyclerView.Adapter<BottomSheetAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(position: Int) {
            val item = List[position]
            itemView.txtvMonth.text = item.value
            itemView.radioButton.isChecked = item.isCheck
            // set listener on radio button
            itemView.layoutItemBottomSheet.setOnClickListener {

                List.forEach { it.isCheck = false }
                item.isCheck = true
                // Call listener
                itemIClickListener.onClick(
                    itemView.txtvMonth.text.toString()

                )
            }
            itemView.radioButton.setOnClickListener {

                List.forEach { it.isCheck = false }
                item.isCheck = true
                // Call listener
                itemIClickListener.onClick(
                    itemView.txtvMonth.text.toString()
                )
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.item_bottom_sheet, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return List.size
    }

}