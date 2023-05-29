package com.example.nytimesclean.utils

import androidx.fragment.app.Fragment
import com.example.nytimesclean.R

fun Fragment.replaceFragment(fragment: Fragment) {
    val transaction = requireActivity().supportFragmentManager.beginTransaction()
    transaction.replace(R.id.fragment_container, fragment)
    transaction.addToBackStack(null)
    transaction.commit()
}

fun Fragment.popBackStack() {
    val fragmentManager = requireActivity().supportFragmentManager
    if (fragmentManager.backStackEntryCount < 1) {
        requireActivity().finish()
    } else {
        fragmentManager.popBackStack()
    }
}