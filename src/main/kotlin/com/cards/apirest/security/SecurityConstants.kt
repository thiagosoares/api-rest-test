package com.cards.apirest.security

class SecurityConstants {
    companion object {
        val SECRET = "SECRET_KEY";
        val EXPIRATION_TIME = 900; // 15 mins
        val TOKEN_PREFIX = "Bearer ";
        val HEADER_STRING = "Authorization";
//        val SIGN_UP_URL = "/api/services/controller/user";

    }
}