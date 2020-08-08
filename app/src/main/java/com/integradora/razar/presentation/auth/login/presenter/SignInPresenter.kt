package com.integradora.razar.presentation.auth.login.presenter

import com.integradora.razar.domain.interactor.auth.logininteractor.SignInInteractor
import com.integradora.razar.presentation.auth.login.LoginContract
import com.integradora.razar.presentation.auth.login.exceptions.LoginException
import kotlinx.coroutines.*
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class SignInPresenter @Inject constructor(private val signInInteractor: SignInInteractor) :
    LoginContract.LoginPresenter, CoroutineScope {
    var view: LoginContract.LoginView? = null

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    private val job = Job()
    override fun attachView(view: LoginContract.LoginView) {
        this.view = view
    }

    override fun dettachView() {
        view = null
    }

    override fun dettachJob() {
        coroutineContext.cancel()
    }

    override fun isViewAttached(): Boolean {
        return view != null
    }

    override fun signInUserWithEmailAndPassword(email: String, password: String) {
        launch {
            view?.showProgressBar()
            try {
                signInInteractor.signInWithEmailAndPassword(email, password)
                if (isViewAttached()) {
                    view?.hideProgressBar()
                    view?.navigateToHome()
                }
            } catch (error: LoginException) {
                if (isViewAttached()) {
                    view?.showError(error.message)
                    view?.hideProgressBar()
                }
            }
        }
    }

    override fun checkEmptyFields(email: String, password: String): Boolean {
        return email.isEmpty() || password.isEmpty()
    }
}