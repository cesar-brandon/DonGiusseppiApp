package dongiusseppi.com.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import dongiusseppi.com.R
import dongiusseppi.com.ui.start.MenuFragment
import dongiusseppi.com.ui.start.PlaceFragment
import dongiusseppi.com.ui.start.WelcomeFragment

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> WelcomeFragment()
            1 -> MenuFragment()
            2 -> PlaceFragment()
            else -> throw IllegalArgumentException("Invalid position: $position")
        }
    }

    override fun getCount(): Int {
        // Show 2 total pages.
        return 3
    }
}