package com.example.trialfragmentchanger

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.trialfragmentchanger.databinding.ActivityMainBinding

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



        binding.bottomNav.setSelectedItemId(R.id.profile)
        replaceFragment(LoginFragment())


        binding.bottomNav.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.profile -> replaceFragment(LoginFragment())
                R.id.myBooks -> replaceFragment(MyBooksFragment())
                R.id.menu -> replaceFragment(MainMenuFragment())
                R.id.search -> replaceFragment(SearchFragment())
            }
            true
        }


    }

    fun replaceFragment(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentLayout, fragment)
            .addToBackStack(null)
            .commit()
    }


}