package ru.rvukolov.diplom.service

import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import ru.rvukolov.diplom.dto.TokenRequest
import ru.rvukolov.diplom.entity.UserEntity
import ru.rvukolov.diplom.exception.CloudServiceException
import ru.rvukolov.diplom.exception.dto.ErrorCode
import ru.rvukolov.diplom.repository.UserRepository

@Service
class UserService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) {

    fun checkCredentials(login: String, password: String) {
        val user = userRepository.findUserByUsername(login).orElseThrow {
            throw CloudServiceException(ErrorCode.BAD_CREDENTIALS)
        }

        if (!passwordEncoder.matches(password, user.password)) throw CloudServiceException(ErrorCode.BAD_CREDENTIALS)
    }
}