package com.integradora.razar.presentation.login.view

import android.os.Bundle
import com.integradora.razar.R
import com.integradora.razar.base.BaseActivity

class LoginActivity: BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.LoginTheme)
        super.onCreate(savedInstanceState)
    }

    override fun getLayout(): Int {
        return R.layout.login_activity
    }
}