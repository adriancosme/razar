package com.integradora.razar.presentation.auth.register.view

import android.content.Intent
import android.os.Bundle
import com.integradora.razar.R
import com.integradora.razar.base.BaseActivity
import com.integradora.razar.presentation.auth.login.view.LoginActivity
import com.integradora.razar.presentation.main.view.MainActivity
import kotlinx.android.synthetic.main.register_activity.*

class RegisterActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.LoginTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_activity)
        btn_sign_up.setOnClickListener {
            signUp()
        }
        txtv_sign_in.setOnClickListener {
            navigateToSignIn()
        }
    }

    override fun getLayout(): Int {
        return R.layout.register_activity
    }

    fun signUp() {
        navigateToHome()
    }

    fun navigateToHome() {
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }

    fun navigateToSignIn(){
        startActivity(Intent(this, LoginActivity::class.java))
    }
}
