package com.integradora.razar.presentation.auth.login

interface LoginContract {
    interface LoginView{
        fun showError(msgError: String?)
        fun showProgressBar()
        fun hideProgressBar()
        fun signIn()
        fun navigateToHome()
        fun navigateToRegister()
        fun navigateToPasswordRecover()
    }

    interface LoginPresenter{
        fun attachView(view: LoginView)
        fun dettachView()
        fun dettachJob()
        fun isViewAttached(): Boolean
        fun signInUserWithEmailAndPassword(email: String, password: String)
        fun checkEmptyFields(email: String, password: String): Boolean
    }
}