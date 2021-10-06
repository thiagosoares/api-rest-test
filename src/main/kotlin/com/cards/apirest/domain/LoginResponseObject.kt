package com.cards.apirest.domain

data class LoginResponseObject(
    //@SerializedName("userId") 
    val userId: String,
    //@SerializedName("token")
    val token: String,
    //@SerializedName("enabled") 
    val enabled: Boolean,
    //@SerializedName("firstName")
    val firstName: String,
    //@SerializedName("lastName") 
    val lastName: String,
    //@SerializedName("fullName") 
    val fullName: String,
    //@SerializedName("cpf") 
    val cpf: String,
    //@SerializedName("email") 
    val email: String,
    //@SerializedName("gender") 
    val gender: String,
    //@SerializedName("birthDate")
    val birthDate: String,
    //@SerializedName("ddd")
    val ddd: String,
    //@SerializedName("phone") 
    val phone: String
)