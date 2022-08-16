package com.example.tococd.presentation.screens.onboarding

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class OnBoardingAdapter(
    fragments: ArrayList<Fragment>,
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    private val fragmentList = fragments

    override fun getItemCount(): Int = fragmentList.count()

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }
}