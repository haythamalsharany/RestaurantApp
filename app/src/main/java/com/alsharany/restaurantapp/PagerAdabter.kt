package com.alsharany.restaurantapp

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter

class PagerAdabter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    val tabs=ArrayList<MyTab>()
    override fun getItemCount(): Int {
        return tabs.size
    }

    override fun createFragment(position: Int): Fragment {
      return  tabs.get(position).fragment

    }

    fun addTab(tab:MyTab){
        tabs.add(tab)
    }

}