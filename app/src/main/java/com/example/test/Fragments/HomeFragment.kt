package com.example.test.Fragments

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.test.R
import com.example.test.adapter.TongYeuCauVayAdapter
import com.example.test.model.MonthModel
import com.example.test.model.tongyeucauvaymodel
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private val listRcv = mutableListOf<tongyeucauvaymodel>()
    private var listMonth: MutableList<MonthModel> = ArrayList()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listRcv.add(tongyeucauvaymodel("0%", "0 yeu cau", 3))
        listRcv.add(tongyeucauvaymodel("100%", "1 yeu cau", 2))
        listRcv.add(tongyeucauvaymodel("0%", "0 yeu cau", 1))
        listRcv.add(tongyeucauvaymodel("0%", "0 yeu cau", 0))
        listRcv.add(tongyeucauvaymodel("0%", "0 yeu cau", 3))
        val rcvAdapter = context?.let { TongYeuCauVayAdapter(it, listRcv) }
        rcvTongYeuCauVay.adapter = rcvAdapter

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
        layoutQuy.setOnClickListener {
//            if (isAdded) {
//                val my = MyBottomSheetFragment()
//                my.show(childFragmentManager, MyBottomSheetFragment.TAG)
//            }
             BottomSheetQuy(requireActivity(),listMonth)
        }

    }

}