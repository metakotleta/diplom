package ru.rvukolov.diplom.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.context.request.ServletWebRequest
import org.springframework.web.context.request.WebRequest
import ru.rvukolov.diplom.exception.dto.ErrorCode
import ru.rvukolov.diplom.exception.dto.ResponseApiError
import java.text.MessageFormat

interface IExceptionHandler {

    fun resolveHttpCode(code: ErrorCode) =
        HttpStatus.resolve(code.errorCode) ?: HttpStatus.INTERNAL_SERVER_ERROR

    fun resolveServiceName(request: WebRequest) =
        (request as ServletWebRequest).request.requestURI.toString()

    fun resolveMessage(code: ErrorCode, parameters: Array<Any?>) =
        MessageFormat.format(code.message, *parameters) ?: ""

    fun createResponse(
        exception: Exception,
        request: WebRequest,
        errorCode: ErrorCode,
        parameters: Array<Any?>?
    ): ResponseEntity<Any> {
        return ResponseEntity(
            ResponseApiError(
                serviceName = resolveServiceName(request),
                id = errorCode.errorCode,
                message = resolveMessage(
                    code = errorCode,
                    parameters = parameters ?: arrayOf()
                )
            ), resolveHttpCode(errorCode)
        )
    }

}