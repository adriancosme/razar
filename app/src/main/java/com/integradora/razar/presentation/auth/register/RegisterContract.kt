package com.integradora.razar.presentation.auth.register


interface RegisterContract {
    interface RegisterView{
        fun showError(msgError: String?)
        fun showProgressBar()
        fun hideProgressBar()
        fun signUp()
        fun navigateToHome()
        fun navigateToRegister()
        fun navigateToPasswordRecover()
    }
    interface RegisterPresenter{
        fun attachView(view: RegisterView)
        fun dettachView()
        fun dettachJob()
        fun isViewAttached(): Boolean
        fun signUp(username: String, password: String)
        fun checkEmptyFields(username: String, password: String): Boolean
    }
}