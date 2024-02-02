package com.example.dongiusseppiapp.ui.main.config

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.dongiusseppiapp.ui.main.tabs.PlaceFragment
import com.example.dongiusseppiapp.ui.main.tabs.StartMenuFragment
import com.example.dongiusseppiapp.ui.main.tabs.WelcomeFragment

class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> WelcomeFragment()
            1 -> StartMenuFragment()
            2 -> PlaceFragment()
            else -> throw IllegalArgumentException("Invalid position: $position")
        }
    }

    override fun getCount(): Int {
        return 3
    }
}