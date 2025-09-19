package com.example.lab_week_04

import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

// Titles for the tabs
val CAFE_TAB_TITLES = listOf(
    R.string.starbucks_title,
    R.string.janjijiwa_title,
    R.string.kopikenangan_title,
)

val CAFE_DESCRIPTIONS = listOf(
    R.string.starbucks_desc,
    R.string.janjijiwa_desc,
    R.string.kopikenangan_desc
)

class CafeAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return CAFE_TAB_TITLES.size
    }

    override fun createFragment(position: Int): Fragment {
        // Pass the description resource ID to CafeDetailFragment
        return CafeDetailFragment.newInstance(CAFE_DESCRIPTIONS[position])
    }

    // This method provides the title for the tab itself
    @StringRes
    fun getTabTitle(position: Int): Int {
        return CAFE_TAB_TITLES[position]
    }
}