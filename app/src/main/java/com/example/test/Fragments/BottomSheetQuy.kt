package com.example.test.Fragments

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Dialog
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import com.example.test.R
import com.example.test.`interface`.IClickListener
import com.example.test.adapter.BottomSheetAdapter
import com.example.test.model.MonthModel
import kotlinx.android.synthetic.main.layout_bottom_sheet.*
import kotlinx.android.synthetic.main.layout_bottom_sheet.view.*

class BottomSheetQuy(
    activity: Activity,
    monthModelList: MutableList<MonthModel>
) {
    private var mBottomSheetDialog: Dialog? = null
    var adapter: BottomSheetAdapter? = null

    init {
        val viewBtt: View = activity.layoutInflater.inflate(R.layout.layout_bottom_sheet, null)

        mBottomSheetDialog = Dialog(activity, R.style.BottomSheetTheme)
        mBottomSheetDialog?.setContentView(viewBtt)
        mBottomSheetDialog?.setCancelable(true)
        mBottomSheetDialog?.window?.setLayout(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        mBottomSheetDialog?.window?.setGravity(Gravity.BOTTOM)
        mBottomSheetDialog?.show()

        val iClickListener = object : IClickListener {
            @SuppressLint("NotifyDataSetChanged")
            override fun onClick(s: String?) {
                // Notify adapter
                viewBtt.rcvBottomSheet.post { adapter?.notifyDataSetChanged() }
                // Display toast
                Toast.makeText(
                    viewBtt.context,
                    "Selected : $s",
                    Toast.LENGTH_SHORT
                ).show()
                mBottomSheetDialog?.dismiss()
            }
        }
        viewBtt.imgClose.setOnClickListener { mBottomSheetDialog?.dismiss() }
        adapter = BottomSheetAdapter(viewBtt.context, monthModelList, iClickListener)
        viewBtt.rcvBottomSheet.adapter = adapter
//        activity.rcvBottomSheet.scrollToPosition(selectPosGender)

    }
}