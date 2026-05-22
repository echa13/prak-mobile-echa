package com.example.orangcantkikapps

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.appcompat.app.AlertDialog
import com.example.orangcantkikapps.databinding.ActivityMainBinding
import com.example.orangcantkikapps.home.pertemuan_4.FourthActivity
import com.example.orangcantkikapps.home.pertemuan_7.SeventhActivity


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Set onClickListener
        binding.btnToFourth.setOnClickListener {

            val intent = Intent(this, FourthActivity::class.java)
            intent.putExtra("nama", "Politeknik Caltex Riau")
            intent.putExtra("asal", "Rumbai")
            intent.putExtra("usia", 25)
            startActivity(intent)
        }
        binding.btnToSeventh.setOnClickListener {

            val intent = Intent(this, SeventhActivity::class.java)
            startActivity(intent)
        }
        binding.btnLogout.setOnClickListener {

            AlertDialog.Builder(this)
                .setTitle("Logout")
                .setMessage("Apakah Anda yakin ingin logout?")
                .setPositiveButton("Ya") { _, _ ->

                    val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)

                    val editor = sharedPref.edit()

                    editor.clear()
                    editor.apply()

                    val intent = Intent(this, AuthActivity::class.java)
                    startActivity(intent)

                    finish()
                }
                .setNegativeButton("Tidak", null)
                .show()
        }
    }
}