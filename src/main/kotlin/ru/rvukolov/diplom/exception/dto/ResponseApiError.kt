package ru.rvukolov.diplom.exception.dto

data class ResponseApiError(
    val serviceName: String,
    val message: String,
    val id: Int
)
