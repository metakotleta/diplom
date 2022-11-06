package ru.rvukolov.diplom.exception.dto

enum class ErrorCode(val errorCode: Int, val message: String) {
    BAD_CREDENTIALS(400, "Bad credentials"),
    INTERNAL_SERVER_ERROR(500, "Internal server error: {0}")
}