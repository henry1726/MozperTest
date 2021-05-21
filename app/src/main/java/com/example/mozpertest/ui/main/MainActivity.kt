package com.example.mozpertest.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.mozpertest.R
import com.example.mozpertest.sys.di.modules.ViewModelModule
import com.example.mozpertest.ui.login.LoginFragment


class MainActivity : AppCompatActivity() {

    lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) supportFragmentManager.beginTransaction()
            .add(R.id.main_activity_content, HomeFragment.newInstance())
            .commit()

        application?.let{
            viewModel = ViewModelProvider(this, ViewModelModule(application)).get(HomeViewModel::class.java)
        }


    }


    override fun onStart() {
        super.onStart()
        downloadEmployees()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }

    private fun downloadEmployees() {
        viewModel.downloadEmployees()
    }
}