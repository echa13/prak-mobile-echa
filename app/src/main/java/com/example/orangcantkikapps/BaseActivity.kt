package com.example.orangcantkikapps

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.orangcantkikapps.Message.MessageFragment
import com.example.orangcantkikapps.More.MoreFragment
import com.example.orangcantkikapps.R
import com.example.orangcantkikapps.databinding.ActivityBaseBinding
import com.example.orangcantkikapps.home.HomeFragment.HomeFragment

class BaseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBaseBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityBaseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomeFragment())
        binding.bottomNavView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
//                    Toast.makeText(this, "Home Clicked", Toast.LENGTH_SHORT).show()
                    replaceFragment(HomeFragment())
                    true
                }
                R.id.message -> {
//                    Toast.makeText(this, "Message Clicked", Toast.LENGTH_SHORT).show()
                    replaceFragment(MessageFragment())
                    true
                }
                R.id.more -> {
//                    Toast.makeText(this, "More Clicked", Toast.LENGTH_SHORT).show()
                    replaceFragment(MoreFragment())
                    true

                }
                else -> false // return false jika item tidak ada yang di klik
            }
        }

    }
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(binding.fragmentContainer.id, fragment)
            //.addToBackStack(null) -> ini kita nonaktifkan agar saat back langsung keluar aplikasi
            .commit()
    }
}

