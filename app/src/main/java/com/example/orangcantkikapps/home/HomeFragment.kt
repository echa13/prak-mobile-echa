package com.example.orangcantkikapps.home.HomeFragment

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.orangcantkikapps.AuthActivity
import com.example.orangcantkikapps.home.pertemuan_7.SeventhActivity
import com.example.orangcantkikapps.R
import com.example.orangcantkikapps.databinding.FragmentHomeBinding
import com.example.orangcantkikapps.home.pertemuan_4.FourthActivity
import com.example.orangcantkikapps.home.pertemuan_9.NinthActivity.NinthActivity

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "Home"
        }
        val sharedPref = requireContext().getSharedPreferences("user_pref", MODE_PRIVATE)
        binding.btnToFourth.setOnClickListener {

            val intent = Intent(requireContext(), FourthActivity::class.java)
            intent.putExtra("nama", "Politeknik Caltex Riau")
            intent.putExtra("asal", "Rumbai")
            intent.putExtra("usia", 25)
            startActivity(intent)
        }
        binding.btnToSeventh.setOnClickListener {

            val intent = Intent(requireContext(), SeventhActivity::class.java)
            startActivity(intent)
        }
        binding.btnToNinth.setOnClickListener {
            val intent = Intent(requireContext(), NinthActivity::class.java)
            startActivity(intent)
        }
        binding.btnLogout.setOnClickListener {

            AlertDialog.Builder(requireContext())
                .setTitle("Logout")
                .setMessage("Apakah Anda yakin ingin logout?")
                .setPositiveButton("Ya") { _, _ ->

                    val editor = sharedPref.edit()

                    editor.clear()
                    editor.apply()

                    val intent = Intent(requireContext(), AuthActivity::class.java)
                    startActivity(intent)
                    requireActivity().finish()
                }
                .setNegativeButton("Tidak", null)
                .show()
        }
    }

}