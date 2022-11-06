package ru.rvukolov.diplom.controller

import antlr.StringUtils
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.*
import ru.rvukolov.diplom.dto.AuthToken
import ru.rvukolov.diplom.dto.TokenRequest
import ru.rvukolov.diplom.service.UserService
import java.time.ZonedDateTime

@RestController
class LoginController(
    private val userService: UserService,
    private val passwordEncoder: PasswordEncoder
) {

    @PostMapping("/login")
    fun login(@RequestBody tokenRequest: TokenRequest): AuthToken {
        val encodedPassword = passwordEncoder.encode(tokenRequest.password)
        userService.checkCredentials(tokenRequest.login, tokenRequest.password)
        return AuthToken(passwordEncoder.encode(tokenRequest.login + encodedPassword + ZonedDateTime.now()).removePrefix("{bcrypt}"))
    }

}