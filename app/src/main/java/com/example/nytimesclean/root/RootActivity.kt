package com.example.nytimesclean.root

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.nytimesclean.R
import com.example.nytimesclean.databinding.ActivityRootBinding
import com.example.nytimesclean.mainPage.ui.MainPageFragment
import com.example.nytimesclean.topStories.ui.TopStoriesPageFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class RootActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRootBinding
    private lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRootBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadFragment(MainPageFragment())
        bottomNav = binding.bottomNavMenu
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.mainPageFragment -> {
                    loadFragment(MainPageFragment())
                    true
                }
                R.id.topStoriesPageFragment -> {
                    loadFragment(TopStoriesPageFragment())
                    true
                }
                else -> false
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()
    }
}