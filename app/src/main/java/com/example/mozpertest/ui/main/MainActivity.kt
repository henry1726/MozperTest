package com.example.mozpertest.ui.main

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import com.example.mozpertest.R
import com.example.mozpertest.sys.di.modules.ViewModelModule


class MainActivity : AppCompatActivity() {

    lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        application?.let{
            viewModel = ViewModelProvider(this, ViewModelModule(it)).get(HomeViewModel::class.java)
        }


        supportFragmentManager.beginTransaction()
            .replace(R.id.main_activity_content, HomeFragment.newInstance())
            .addToBackStack("n")
            .commit()

    }

    override fun onBackPressed() {
        val fm: FragmentManager = supportFragmentManager
        if (fm.getBackStackEntryCount() > 0) {
            Log.i("MainActivity", "popping backstack")
            fm.popBackStack()
        } else {
            Log.i("MainActivity", "nothing on backstack, calling super")
            super.onBackPressed()
        }
    }

    override fun onStart() {
        super.onStart()

        //downloadEmployees()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }

    private fun downloadEmployees() {
        viewModel.downloadEmployees()
    }
}