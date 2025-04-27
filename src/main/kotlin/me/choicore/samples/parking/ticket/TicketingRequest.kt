package me.choicore.samples.parking.ticket

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import me.choicore.samples.parking.LicensePlateNumber
import java.time.LocalDateTime

sealed interface TicketingRequest {
    data class Automatic(
        @field:LicensePlateNumber
        val lpn: String,
        @field:NotBlank(message = "발급기를 확인해주세요.")
        val src: String,
        @field:NotNull(message = "요청 시간을 확인해주세요.")
        val ts: LocalDateTime,
    ) : TicketingRequest
}
