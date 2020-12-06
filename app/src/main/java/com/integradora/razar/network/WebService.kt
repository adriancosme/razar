package com.integradora.razar.network

import com.integradora.razar.domain.models.User
import retrofit2.Call
import retrofit2.http.*

interface WebService {
    @POST("/auth/login")
    suspend fun login(@Query("username") username: String, @Query("password") password: String) {

    }

    @FormUrlEncoded
    @POST("/api/users")
    fun register(
        @Field("username") username: String,
        @Field("password") password: String
    ): Call<User>
}