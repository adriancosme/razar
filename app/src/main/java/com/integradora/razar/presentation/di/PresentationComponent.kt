package com.integradora.razar.presentation.di

import com.integradora.razar.presentation.auth.login.view.LoginActivity
import com.integradora.razar.presentation.auth.register.view.RegisterActivity
import dagger.Component
import javax.inject.Singleton

@Component(modules = [PresentationModule::class])

@Singleton
interface PresentationComponent {
    fun inject(loginActivity: LoginActivity)
    fun inject(registerActivity: RegisterActivity)
}