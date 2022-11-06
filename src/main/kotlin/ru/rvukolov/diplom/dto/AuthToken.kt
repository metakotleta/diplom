package ru.rvukolov.diplom.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class AuthToken(
    @JsonProperty("auth-token")
    val inputString: String
)