package ru.rvukolov.diplom.entity

import javax.persistence.*

@Entity
@Table(name = "users", schema = "public")
class UserEntity: java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    val username: String? = null

    val password: String? = null
}