package com.example.orangcantkikapps.home.pertemuan_10

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.tabs.TabLayoutMediator
import com.example.orangcantkikapps.R
import com.example.orangcantkikapps.databinding.ActivityTenthBinding
import com.example.orangcantkikapps.home.pertemuan_10.TenthTabsAdapter

class TenthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTenthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTenthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1. Setup Toolbar & Tombol Back
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        // 2. Inisialisasi Adapter
        val tabsAdapter = TenthTabsAdapter(this)

        // 3. Set adapter ke ViewPager2
        binding.viewPager.adapter = tabsAdapter

        // 4. Hubungkan TabLayout & ViewPager2 menggunakan TabLayoutMediator
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Tab A"
                    tab.icon = ContextCompat.getDrawable(this, android.R.drawable.ic_dialog_info)
                    val badge = tab.getOrCreateBadge()
                    badge.isVisible = true
                }
                1 -> {
                    tab.text = "Tab B"
                    tab.icon = ContextCompat.getDrawable(this, android.R.drawable.ic_dialog_email)
                    val badge = tab.getOrCreateBadge()
                    badge.isVisible = true
                    badge.number = 5
                }
                2 -> {
                    tab.text = "Produk" // Label tab ketiga
                    tab.icon = ContextCompat.getDrawable(this, android.R.drawable.ic_menu_gallery) // Menambahkan icon galeri/produk
                }
            }
        }.attach()
    }
}