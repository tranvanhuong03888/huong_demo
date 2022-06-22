package com.example.test.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.test.R
import com.example.test.model.tongyeucauvaymodel
import kotlinx.android.synthetic.main.item_tong_yeu_cau_vay.view.*

class TongYeuCauVayAdapter(
    private val context: Context,
    private val List: List<tongyeucauvaymodel>
) : RecyclerView.Adapter<TongYeuCauVayAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("SetTextI18n")
        fun bind(position: Int) {
            val item = List[position]
            itemView.tvPhanTram.text = item.item1
            itemView.tvYeuCau.text = item.item2
            when (item.item3) {
                0 -> {
                    itemView.tvTrangThai.text = "Bị từ chối/Đã hủy"
                    itemView.viewItemTYCV.setBackgroundResource(R.drawable.bgr_item_tycv_cancel)
                }
                1 -> {
                    itemView.tvTrangThai.text = "Chờ xử lý"
                    itemView.viewItemTYCV.setBackgroundResource(R.drawable.bgr_item_tycv_cxl)
                }
                2 -> {
                    itemView.tvTrangThai.text = "Đang xử lý"
                    itemView.viewItemTYCV.setBackgroundResource(R.drawable.bgr_item_tycv_dxl)
                }
                3 -> {
                    itemView.tvTrangThai.text = "Hoàn tất"
                    itemView.viewItemTYCV.setBackgroundResource(R.drawable.bgr_item_tycv_ht)
                }
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.item_tong_yeu_cau_vay, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return List.size
    }

}