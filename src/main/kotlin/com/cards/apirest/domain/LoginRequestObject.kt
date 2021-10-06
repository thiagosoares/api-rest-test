package com.cards.apirest.domain

data class LoginRequestObject(
    //@SerializedName("cpf")
    val cpf: String,
    //@SerializedName("password")
    val password: String
)
