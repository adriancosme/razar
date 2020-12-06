package com.integradora.razar.presentation.auth.register.presenter

import android.widget.Toast
import com.integradora.razar.domain.interactor.auth.registerinteractor.SignUpInteractor
import com.integradora.razar.presentation.auth.register.RegisterContract
import com.integradora.razar.presentation.auth.register.exceptions.SignUpException
import kotlinx.coroutines.*
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class SignUpPresenter @Inject constructor(private val signUpInteractor: SignUpInteractor) :
    RegisterContract.RegisterPresenter,
    CoroutineScope {
    var view: RegisterContract.RegisterView? = null
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    private val job = Job()
    override fun attachView(view: RegisterContract.RegisterView) {
        this.view = view
    }

    override fun dettachView() {
        this.view = null
    }

    override fun dettachJob() {
        coroutineContext.cancel()
    }

    override fun isViewAttached(): Boolean {
        return view != null
    }

    override fun signUp(username: String, password: String) {
        launch {
            view?.showProgressBar()
            try {
                signUpInteractor.signUp(username, password)
                if (isViewAttached()) {
                    view?.hideProgressBar()

                }
            } catch (error: SignUpException) {
                if (isViewAttached()) {
                    view?.showError(error.message)
                    view?.hideProgressBar()
                }
            }
        }
    }

    override fun checkEmptyFields(username: String, password: String): Boolean {
        return username.isEmpty() || password.isEmpty()
    }
}