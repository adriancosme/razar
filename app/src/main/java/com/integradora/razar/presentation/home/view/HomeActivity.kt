package com.integradora.razar.presentation.home.view

import android.os.Bundle
import com.integradora.razar.R
import com.integradora.razar.base.BaseActivity

class HomeActivity: BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
    }

    override fun getLayout(): Int {
        return R.layout.home_activity
    }
}