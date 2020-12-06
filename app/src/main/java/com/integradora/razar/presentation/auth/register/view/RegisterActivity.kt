package com.integradora.razar.presentation.auth.register.view

import android.content.Intent
import android.os.Bundle
import com.integradora.razar.R
import com.integradora.razar.RazarApp
import com.integradora.razar.base.BaseActivity
import com.integradora.razar.presentation.auth.login.view.LoginActivity
import com.integradora.razar.presentation.auth.register.RegisterContract
import com.integradora.razar.presentation.auth.register.presenter.SignUpPresenter
import com.integradora.razar.presentation.main.view.MainActivity
import kotlinx.android.synthetic.main.login_activity.*
import kotlinx.android.synthetic.main.register_activity.*
import javax.inject.Inject

class RegisterActivity : BaseActivity(), RegisterContract.RegisterView {
    @Inject
    lateinit var presenter: SignUpPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.LoginTheme)
        super.onCreate(savedInstanceState)
        (application as RazarApp).getAppComponent()?.inject(this)
        presenter.attachView(this)
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

    override fun showError(msgError: String?) {
        toast(this, msgError)
    }

    override fun showProgressBar() {
        toast(this, "Progressbar")
    }

    override fun hideProgressBar() {
        toast(this, "no progressbar")
    }

    override fun signUp() {
        val username = etxt_username.text.toString().trim()
        val password = etxt_password_register.text.toString().trim()
        if (presenter.checkEmptyFields(username, password)) {
            showError("Uno o ambos campos estan vacios")
        } else {
            presenter.signUp(username, password)
        }


    }

    override fun navigateToHome() {
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }

    override fun navigateToRegister() {
        TODO("Not yet implemented")
    }

    override fun navigateToPasswordRecover() {
        TODO("Not yet implemented")
    }

    fun navigateToSignIn() {
        startActivity(Intent(this, LoginActivity::class.java))
    }
}
