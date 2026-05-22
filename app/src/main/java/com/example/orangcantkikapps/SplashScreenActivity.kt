package com.example.orangcantkikapps

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.orangcantkikapps.databinding.ActivitySplashScreenBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->

            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())

            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )

            insets
        }

        lifecycleScope.launch {

            // Delay splash screen 2 detik
            delay(2000)

            // SharedPreferences
            val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)

            // Ambil status login
            val isLogin = sharedPref.getBoolean("isLogin", false)

            // Cek login
            val intent = if (isLogin) {

                Intent(this@SplashScreenActivity, BaseActivity::class.java)

            } else {

                Intent(this@SplashScreenActivity, AuthActivity::class.java)
            }

            startActivity(intent)
            finish()
        }
    }
}