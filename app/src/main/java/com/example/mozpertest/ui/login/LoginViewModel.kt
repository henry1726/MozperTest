package com.example.mozpertest.ui.login

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel(private val c: Context): ViewModel() {


    private lateinit var sharedPreferences: SharedPreferences

    val hasLoggedUser by lazy { MutableLiveData<Boolean>() }

    val logginUser by lazy { MutableLiveData<Boolean>() }

    fun hasLoggedUser(){
        hasLoggedUser.value = hasUserLogged()
    }

    fun logginUser(){
        logginUser.value = saveToken()
    }



    private fun hasUserLogged(): Boolean {
        val sp = c.getSharedPreferences("SP_USER", Context.MODE_PRIVATE)
        val token: String? = sp.getString("TOKEN", "")
        return token?.isNotBlank()?: false
    }


    private fun saveToken(): Boolean {
        val sp = c.getSharedPreferences("SP_USER", Context.MODE_PRIVATE)
        val editor = sp.edit()
        editor.putString("TOKEN", "43hJD(nnu7363ndi")
        return editor.commit()
    }

}
