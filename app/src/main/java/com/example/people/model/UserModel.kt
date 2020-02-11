package com.example.people.model

import com.google.gson.annotations.SerializedName

data class UserModel(

    @SerializedName( "id")
    val id : Int?,

    @SerializedName("first_name")
    val first_name : String?,

    @SerializedName("last_name")
    val last_name : String?,

    @SerializedName("avatar")
    val avatar : String?

){

}

data class UserResponse(
    val page:Int?,
    val per_page:Int?,
    val total : Int?,

    val userModels : List<UserModel>
)