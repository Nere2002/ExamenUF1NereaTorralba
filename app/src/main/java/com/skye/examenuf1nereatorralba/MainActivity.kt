package com.skye.examenuf1nereatorralba

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.fragment.findNavController
import com.skye.examenuf1nereatorralba.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Log.d("MainActivity", "onCreate")

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.bottomNavigationView.setOnNavigationItemSelectedListener { item ->

            val navController =
                supportFragmentManager.findFragmentById(R.id.navHostFragment)?.findNavController()

            when (item.itemId) {
                R.id.action_alumnesFragment -> {
                    navController?.navigate(R.id.alumnesFragment)
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.action_grupFragment -> {
                    navController?.navigate(R.id.grupFragment)
                    return@setOnNavigationItemSelectedListener true
                }

                else -> return@setOnNavigationItemSelectedListener false
            }
        }
    }
}