package com.cards.apirest.services

import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserDetailsServiceImpl : UserDetailsService {

    override fun loadUserByUsername(username: String?): UserDetails {
        return  User.builder().username("foo").password("foo").roles("USER").build()
    }
}