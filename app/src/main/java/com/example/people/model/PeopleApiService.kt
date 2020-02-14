package com.example.people.model

import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class PeopleApiService {

    private val BASE_URL = "https://reqres.in/api/"

    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(PeopleApi::class.java)

    fun getPeeps(): Single<List<UserResponse>> {
        return api.getPeople(12)
    }
}