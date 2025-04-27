package me.choicore.samples.parking

import com.fasterxml.jackson.annotation.JsonPropertyOrder
import org.slf4j.MDC

@JsonPropertyOrder("traceId")
sealed class ResponseBody {
    val traceId: String = MDC.get("traceId")

    data class Item<T>(
        val data: T,
    ) : ResponseBody()

    data class Items<T>(
        val data: Pagination<T>,
    ) : ResponseBody()

    data class Error(
        val error: ErrorDetails,
    ) : ResponseBody() {
        data class ErrorDetails(
            val code: String,
            val message: String,
            val details: Map<String, Any>? = null,
        )

        companion object {
            fun of(
                code: String,
                message: String,
                details: Map<String, Any>? = null,
            ): Error =
                Error(
                    ErrorDetails(
                        code = code,
                        message = message,
                        details = details,
                    ),
                )
        }
    }
}
