package com.integradora.razar

import android.app.Application
import com.integradora.razar.presentation.di.DaggerPresentationComponent
import com.integradora.razar.presentation.di.PresentationComponent
import com.integradora.razar.presentation.di.PresentationModule

class RazarApp : Application() {
    private var appComponent: PresentationComponent? = null

    override fun onCreate() {
        super.onCreate()
        appComponent =
            DaggerPresentationComponent.builder().presentationModule(PresentationModule()).build()
    }

    fun getAppComponent(): PresentationComponent? = appComponent
}