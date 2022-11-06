package ru.rvukolov.diplom.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.rvukolov.diplom.entity.UserEntity
import java.util.*

interface UserRepository: JpaRepository<UserEntity, Long>  {

    fun findUserByUsername(username: String): Optional<UserEntity>
}