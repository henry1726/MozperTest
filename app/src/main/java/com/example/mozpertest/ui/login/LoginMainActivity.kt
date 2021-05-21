package com.example.mozpertest.ui.login

import com.example.mozpertest.R
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class LoginMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        if (savedInstanceState == null) supportFragmentManager.beginTransaction()
            .add(R.id.act_login_container, LoginFragment.newInstance())
            .commit()
    }
}