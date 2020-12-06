package com.integradora.razar.domain.interactor.auth.registerinteractor

import com.integradora.razar.network.RetrofitClient

interface SignUpInteractor {
    interface RegisterCallback {
        fun onRegisterSuccess()
        fun onRegisterFailure(errorMsg: String)
    }

    fun signUp(username: String, password: String)
}