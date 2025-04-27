package me.choicore.samples.parking

import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ApplicationExceptionHandler {
    @ExceptionHandler(IllegalArgumentException::class)
    fun handleIllegalArgumentException(ex: IllegalArgumentException): ResponseEntity<Any> =
        ResponseEntity
            .badRequest()
            .contentType(MediaType.APPLICATION_PROBLEM_JSON)
            .body(
                ResponseBody.Error.of(
                    code = "BAD_REQUEST",
                    message = ex.message ?: "잘못된 요청입니다.",
                ),
            )

    @ExceptionHandler(IllegalStateException::class)
    fun handleIllegalStateException(ex: IllegalStateException): ResponseEntity<Any> =
        ResponseEntity
            .badRequest()
            .contentType(MediaType.APPLICATION_PROBLEM_JSON)
            .body(
                ResponseBody.Error.of(
                    code = "BAD_REQUEST",
                    message = ex.message ?: "잘못된 요청입니다.",
                ),
            )
}
