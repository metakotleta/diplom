package ru.rvukolov.diplom.exception

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import ru.rvukolov.diplom.exception.dto.ErrorCode

@ControllerAdvice
class CloudServiceIExceptionHandler: IExceptionHandler {

    @ExceptionHandler
    fun handleCloudServiceException(exception: CloudServiceException, request: WebRequest): ResponseEntity<Any> {
        return createResponse(exception, request, exception.code, exception.parameters)
    }

    @ExceptionHandler
    fun handleUnknownException(exception: RuntimeException, request: WebRequest): ResponseEntity<Any> {
        return createResponse(exception, request, ErrorCode.INTERNAL_SERVER_ERROR, arrayOf(exception.message ?: exception.cause?.message ?: "unknown error details"))
    }
}