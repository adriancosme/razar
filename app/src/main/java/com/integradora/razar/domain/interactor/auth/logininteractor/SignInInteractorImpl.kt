package com.integradora.razar.domain.interactor.auth.logininteractor

class SignInInteractorImpl: SignInInteractor {
    override suspend fun signInWithEmailAndPassword(email: String, password: String) {
        print("Hola desde SignInInteractorImpl")
    }

}