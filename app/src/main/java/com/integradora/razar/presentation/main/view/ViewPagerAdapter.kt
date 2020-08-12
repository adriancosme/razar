package com.integradora.razar.presentation.main.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.integradora.razar.presentation.bookmarks.view.BookmarksFragment
import com.integradora.razar.presentation.categories.view.CategoriesFragment
import com.integradora.razar.presentation.home.HomeFragment
import com.integradora.razar.presentation.settings.view.SettingsFragment

class ViewPagerAdapter(fragment: FragmentActivity) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                HomeFragment()
            }
            1 -> {
                CategoriesFragment()
            }
            2 -> {
                BookmarksFragment()
            }
            3 -> {
                SettingsFragment()
            }
            else -> HomeFragment()
        }
    }
}