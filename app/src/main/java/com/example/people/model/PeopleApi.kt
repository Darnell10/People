package com.example.people.model

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface PeopleApi {
    @GET("users")
    fun getPeople(@Query("per_page") per_page : Int):Single<List<UserResponse>>
}