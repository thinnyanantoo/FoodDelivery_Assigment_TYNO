package com.padc.fooddelivery_assigment_tyno.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.padc.fooddelivery_assigment_tyno.fragments.IntroFragmentOne
import com.padc.fooddelivery_assigment_tyno.fragments.IntroFragmentThree
import com.padc.fooddelivery_assigment_tyno.fragments.IntroFragmentTwo

class ViewPagerTwoAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                IntroFragmentOne.newInstance("A", "B")
            }
            1 -> {
                IntroFragmentTwo.newInstance("A", "B")
            }
            2 -> {
                IntroFragmentThree.newInstance("A", "B")
            }
            else -> {
                IntroFragmentOne.newInstance("A", "B")
            }
        }
    }
}