package com.integradora.razar.domain.interactor.auth.registerinteractor

interface SignUpInteractor {
    interface RegisterCallback{
        fun onRegisterSuccess()
        fun onRegisterFailure(errorMsg:String)
    }

    fun signUp(fullname:String,email:String,password:String,listener:RegisterCallback)
}