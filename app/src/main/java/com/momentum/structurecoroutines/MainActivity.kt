package com.momentum.structurecoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpFragment()
    }

    private fun setUpFragment() {
        val fragment = RecyclerListFragment.newInstance()
        supportFragmentManager.beginTransaction().replace(android.R.id.content, fragment).commit()
    }
}