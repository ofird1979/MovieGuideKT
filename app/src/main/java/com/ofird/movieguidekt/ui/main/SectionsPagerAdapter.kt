package com.ofird.movieguidekt.ui.main

import android.content.Context
import android.graphics.drawable.AdaptiveIconDrawable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.ofird.movieguidekt.R
import com.ofird.movieguidekt.fragments.FavoritesFragment
import com.ofird.movieguidekt.fragments.MostPopularFragment
import com.ofird.movieguidekt.fragments.SearchFragment
import com.ofird.movieguidekt.fragments.TopRatedFragment
import com.ofird.movieguidekt.model.Movie

private val TAB_TITLES = arrayOf(
    R.string.tab_text_1,
    R.string.tab_text_2,
    R.string.tab_text_3,
    R.string.tab_text_4
)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {


    
    override fun getItem(position: Int): Fragment {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
when(position){
    0->FavoritesFragment()
    1-> MostPopularFragment()
    2-> TopRatedFragment()
    else-> SearchFragment()
}

        return PlaceholderFragment.newInstance(position + 1)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        // Show 2 total pages.
        return 4
    }
}