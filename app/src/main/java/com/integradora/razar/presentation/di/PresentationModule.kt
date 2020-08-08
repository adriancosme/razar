package com.integradora.razar.presentation.di

import com.integradora.razar.domain.interactor.auth.logininteractor.SignInInteractor
import com.integradora.razar.domain.interactor.auth.logininteractor.SignInInteractorImpl
import com.integradora.razar.domain.interactor.auth.registerinteractor.SignUpInteractor
import com.integradora.razar.domain.interactor.auth.registerinteractor.SignUpInteractorImpl
import dagger.Module
import dagger.Provides

@Module
class PresentationModule {
    @Provides
    fun provideSignInInteractor(): SignInInteractor = SignInInteractorImpl()

    @Provides
    fun provideSignUpInteractor(): SignUpInteractor = SignUpInteractorImpl()
}