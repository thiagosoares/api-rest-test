package com.cards.apirest.services

import com.cards.apirest.domain.LoginRequestObject
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService {

//    @Autowired
//    private lateinit var bCryptPasswordEncoder: BCryptPasswordEncoder


    fun validate(user: LoginRequestObject): LoginRequestObject {
        return user
    }

}