package com.cards.apirest.security

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Component
import java.util.*

@Component
class JWTUtil {

//    @Value("\${jwt.secret}")
    private  var secret: String = "1234"

    private val expiration: Long = 600000

    fun generateToken(username: String): String {
     // val claims =  mapOf<String, Objects>()

        return Jwts.builder()
//            .setClaims(claims)
            .setSubject(username)
            .setIssuedAt(Date(System.currentTimeMillis()))
            .setExpiration(Date(System.currentTimeMillis() + expiration))
            .signWith(SignatureAlgorithm.HS256, secret.toByteArray())
            .compact()
    }

    fun isTokenValid(token: String): Boolean {
        val claims = getClaimsToken(token)
        if (claims != null) {
            val username = claims.subject
            val expirationDate = claims.expiration
            val now = Date(System.currentTimeMillis())
            if (username != null && expirationDate != null && now.before(expirationDate)) {
                return true
            }
        }
        return false
    }


    private fun getClaimsToken(token: String): Claims? {
        return try {
            Jwts.parser().setSigningKey(secret.toByteArray()).parseClaimsJws(token).body
        } catch (e: Exception) {
            null
        }
    }

    fun getUserName(token: String): String? {
        val claims = getClaimsToken(token)
        return claims?.subject
    }

}