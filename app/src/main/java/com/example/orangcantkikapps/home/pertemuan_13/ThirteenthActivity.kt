package com.example.orangcantkikapps.home.pertemuan_13

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.orangcantkikapps.databinding.ActivityThirteenthBinding
import com.google.android.material.tabs.TabLayoutMediator
import com.example.orangcantkikapps.home.pertemuan_13.ThirteenthTabsAdapter

class ThirteenthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThirteenthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Menerapkan binding di ThirteenthActivity sesuai petunjuk modul atas
        binding = ActivityThirteenthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup Toolbar beserta tombol back (Cukup ConstraintLayout saja)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        // Setup TabLayout dengan ViewPager2 menggunakan ThirteenthTabsAdapter
        val adapter = ThirteenthTabsAdapter(this)
        binding.viewPager.adapter = adapter

        // Menghubungkan TabLayout dan ViewPager2 (Ref: File Pertemuan 10)
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Capture"
                1 -> "Scan"
                2 -> "QR Code"
                else -> null
            }
        }.attach()
    }
}