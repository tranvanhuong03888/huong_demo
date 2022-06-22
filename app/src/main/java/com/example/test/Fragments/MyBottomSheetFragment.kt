package com.example.test.Fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.test.R
import com.example.test.`interface`.IClickListener
import com.example.test.adapter.BottomSheetAdapter
import com.example.test.model.MonthModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.layout_bottom_sheet.*


class MyBottomSheetFragment : BottomSheetDialogFragment() {
    private var listMonth: MutableList<MonthModel> = ArrayList()
    var bottomSheetAdapter: BottomSheetAdapter? = null

    companion object {
        const val TAG = "CustomBottomSheetDialogFragment"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.BottomSheetTheme);
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.layout_bottom_sheet, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val monthModel = MonthModel(1, "asdas")
        val monthModel2 = MonthModel(2, "asdas")
        val monthModel3 = MonthModel(3, "asdas")
        val monthModel4 = MonthModel(4, "asdas")
        val monthModel5 = MonthModel(5, "asdas")
        listMonth.add(monthModel)
        listMonth.add(monthModel2)
        listMonth.add(monthModel3)
        listMonth.add(monthModel4)
        listMonth.add(monthModel5)
        val iClickListener = object : IClickListener {
            @SuppressLint("NotifyDataSetChanged")
            override fun onClick(s: String?) {
                // Notify adapter
                rcvBottomSheet.post { bottomSheetAdapter?.notifyDataSetChanged() }
                // Display toast
                Toast.makeText(
                    context,
                    "Selected : $s",
                    Toast.LENGTH_SHORT
                ).show()
                dismiss()
            }
        }
        imgClose.setOnClickListener {
            dismiss()
        }
        bottomSheetAdapter = context?.let { BottomSheetAdapter(it, listMonth, iClickListener) }

        rcvBottomSheet.adapter = bottomSheetAdapter
    }

}