package com.integradora.razar.presentation.auth.register.view

import android.os.Bundle
import com.integradora.razar.R
import com.integradora.razar.base.BaseActivity

class RegisterActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.LoginTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_activity)
    }

    override fun getLayout(): Int {
        return R.layout.register_activity
    }
}
