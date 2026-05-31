package com.yourpackage.home.pertemuan_10 // Sesuaikan dengan package milikmu

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.orangcantkikapps.home.pertemuan_10.TabAFragment
import com.example.orangcantkikapps.home.pertemuan_10.TabBFragment

class TenthTabsAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    // Jumlah total tab yang ada
    override fun getItemCount(): Int = 2

    // Menentukan Fragment mana yang akan ditampilkan berdasarkan posisi tab
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> TabAFragment()
            1 -> TabBFragment()
            else -> throw IllegalStateException("Posisi tidak valid")
        }
    }
}