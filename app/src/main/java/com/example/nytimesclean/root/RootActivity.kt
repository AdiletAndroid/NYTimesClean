package com.example.nytimesclean.root

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.nytimesclean.R
import com.example.nytimesclean.databinding.ActivityRootBinding
import com.example.nytimesclean.mainPage.ui.MainPageFragment
import com.example.nytimesclean.mostPopular.ui.PopularArticleFragment
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
                    loadFragment(PopularArticleFragment())
                    true
                }

                else -> false
            }
        }
        val window: Window = window
        window.statusBarColor = ContextCompat.getColor(this, R.color.gray)
        bottomNav.selectedItemId = R.id.mainPageFragment
        bottomNav.itemIconTintList =
            ColorStateList.valueOf(ContextCompat.getColor(this, R.color.dark_gray))
        bottomNav.itemTextColor =
            ColorStateList.valueOf(ContextCompat.getColor(this, R.color.dark_gray))
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()
    }
}