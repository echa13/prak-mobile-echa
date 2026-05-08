package com.example.orangcantkikapps

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.orangcantkikapps.databinding.ActivityAuthBinding

class AuthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom
            )
            insets
        }

        // SharedPreferences
        val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)

        // Cek apakah sudah login
        val isLogin = sharedPref.getBoolean("isLogin", false)

        if (isLogin) {

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

            finish()
        }

        // Login Button
        binding.btnLogin.setOnClickListener {

            val username = binding.edtUsername.text.toString()
            val password = binding.edtPassword.text.toString()

            if (username == password) {

                // Simpan status login
                val editor = sharedPref.edit()

                editor.putBoolean("isLogin", true)
                editor.putString("username", username)

                editor.apply()

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)

                finish()

            } else {

                AlertDialog.Builder(this)
                    .setTitle("Login Gagal")
                    .setMessage("Silahkan coba lagi")
                    .setPositiveButton("OK") { dialog, _ ->

                        val editor = sharedPref.edit()

                        editor.clear()
                        editor.apply()

                        dialog.dismiss()
                    }
                    .show()
            }
        }
    }
}