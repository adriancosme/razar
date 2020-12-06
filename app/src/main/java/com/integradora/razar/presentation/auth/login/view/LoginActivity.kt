package com.integradora.razar.presentation.auth.login.view

import android.content.Intent
import android.os.Bundle
import com.integradora.razar.R
import com.integradora.razar.RazarApp
import com.integradora.razar.base.BaseActivity
import com.integradora.razar.presentation.main.view.MainActivity
import com.integradora.razar.presentation.auth.login.LoginContract
import com.integradora.razar.presentation.auth.login.presenter.SignInPresenter
import com.integradora.razar.presentation.auth.register.view.RegisterActivity
import kotlinx.android.synthetic.main.login_activity.*
import javax.inject.Inject

class LoginActivity : BaseActivity(), LoginContract.LoginView {

    @Inject
    lateinit var presenter: SignInPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.LoginTheme)
        super.onCreate(savedInstanceState)
        (application as RazarApp).getAppComponent()?.inject(this)
        presenter.attachView(this)
        btn_sign_in.setOnClickListener {
            signIn()
        }
        txtv_register.setOnClickListener{
            navigateToRegister()
        }
    }

    override fun getLayout(): Int {
        return R.layout.login_activity
    }

    override fun showError(msgError: String?) {
        toast(this, msgError)
    }

    override fun showProgressBar() {
        toast(this, "Progressbar")
    }

    override fun hideProgressBar() {
        toast(this, "NoProgressbar")
    }

    override fun signIn() {
        val email = etxt_email.text.toString().trim()
        val password = etxt_password_login.text.toString().trim()
        if (presenter.checkEmptyFields(
                email,
                password
            )
        ) showError("Uno o ambos campos estan vacios") else presenter.signInUserWithEmailAndPassword(
            email,
            password
        )
    }

    override fun navigateToHome() {
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }

    override fun navigateToRegister() {
        startActivity(Intent(this, RegisterActivity::class.java))
    }

    override fun navigateToPasswordRecover() {
        TODO("Not yet implemented")
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.dettachView()
        presenter.dettachJob()
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        presenter.dettachView()
        presenter.dettachJob()
    }
}