package ru.rvukolov.diplom.exception

import ru.rvukolov.diplom.exception.dto.ErrorCode

class CloudServiceException(
    var code: ErrorCode,
    var parameters: Array<Any?>?
) : RuntimeException() {
    constructor(code: ErrorCode) : this(code, arrayOf(""))
}