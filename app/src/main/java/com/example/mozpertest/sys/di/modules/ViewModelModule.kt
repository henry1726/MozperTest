package com.example.mozpertest.sys.di.modules

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mozpertest.ui.main.HomeViewModel

class ViewModelModule(application: Application) : ViewModelProvider.NewInstanceFactory()  {

    private val mApplication: Application = application

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when{
            modelClass.isAssignableFrom( HomeViewModel::class.java) -> HomeViewModel() as T
            else -> throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}