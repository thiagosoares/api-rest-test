package com.cards.apirest.resources

import com.cards.apirest.domain.Card
import com.cards.apirest.domain.LoginRequestObject
import com.cards.apirest.domain.LoginResponseObject
import com.cards.apirest.security.JWTUtil
import com.cards.apirest.services.UserDetailsServiceImpl
import com.cards.apirest.services.UserService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/api"])
class CardResource {

    private val logger: org.slf4j.Logger = LoggerFactory.getLogger(CardResource::class.java)

    @Autowired
    private lateinit var userService: UserService

    @Autowired
    private lateinit var jwtUtil: JWTUtil

    @Autowired
    private lateinit var userDetailsService: UserDetailsServiceImpl

    @Autowired
    private lateinit var authenticationManager: AuthenticationManager

    @GetMapping("/cards")
    fun cards(): List<Card> {
        return listOf(
            Card("1234", "Refeição"),
            Card("5678", "Alimentação")
        )
    }

    @RequestMapping(value = ["/p/authentication/login"], method = [RequestMethod.POST])
    fun login(@RequestBody loginRequest: LoginRequestObject): ResponseEntity<LoginResponseObject> {

        logger.info(loginRequest.toString())

//        val userDetails = userDetailsService.loadUserByUsername(loginRequest.cpf)
//        if (!(userDetails.password.equals(loginRequest.password) && userDetails.username.equals(loginRequest.cpf))) {
//            throw Exception("Incorrect username or password")
//        }

        try {
            val authReq = UsernamePasswordAuthenticationToken("foo", "foo")
            val authentication = authenticationManager.authenticate(authReq)

            SecurityContextHolder.getContext().authentication = authentication

        } catch (e: Exception) {
            e.printStackTrace()
            throw Exception("Invalidad User")
        }

        val jwt = jwtUtil.generateToken(loginRequest.cpf)

        //val user = userService.validate(loginRequest)

        return ResponseEntity.ok().body(
            LoginResponseObject(
                userId = "",
                token = jwt,
                enabled = true,
                firstName = "",
                lastName = "",
                fullName = "",
                cpf = loginRequest.cpf,
                email = "",
                gender = "",
                birthDate = "",
                ddd = "",
                phone = ""
            )
        )
    }


}