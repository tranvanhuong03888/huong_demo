package com.example.test.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.test.Fragments.CalculateFragment
import com.example.test.Fragments.HomeFragment
import com.example.test.Fragments.LoanFragment
import com.example.test.Fragments.OtherFragment
import com.example.test.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navView.itemIconTintList = null
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        moveToFragment(HomeFragment())
    }

    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {

                R.id.item1 -> {
                    moveToFragment(HomeFragment())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.item2 -> {
                    moveToFragment(CalculateFragment())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.item3 -> {
                    moveToFragment(LoanFragment())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.item4 -> {
                    moveToFragment(OtherFragment())
                    return@OnNavigationItemSelectedListener true
                }

            }
//            if (selectedFragment != null){
//                supportFragmentManager.beginTransaction().replace(
//                    R.id.fragment_container_view_tag,
//                    selectedFragment!!
//                ).commit()
//            }
            false
        }

    private fun moveToFragment(fragment: Fragment) {
        val fragmentTrans = supportFragmentManager.beginTransaction()
        fragmentTrans.replace(R.id.fragment_container_view_tag, fragment)
        fragmentTrans.commit()
    }
}