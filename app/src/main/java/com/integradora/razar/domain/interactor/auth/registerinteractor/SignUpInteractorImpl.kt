package com.integradora.razar.domain.interactor.auth.registerinteractor

import com.integradora.razar.domain.models.User
import com.integradora.razar.network.RetrofitClient
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpInteractorImpl : SignUpInteractor {
    override fun signUp(username: String, password: String) {
        RetrofitClient.instance.register(username, password).enqueue(object :
            Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                println(response.body())
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                println(t.message)
            }

        })
    }
}