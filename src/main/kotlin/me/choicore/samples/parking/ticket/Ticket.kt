package me.choicore.samples.parking.ticket

import java.time.LocalDateTime
import java.time.temporal.ChronoUnit.SECONDS

data class Ticket(
    val id: Long = 0,
    val complexId: Long,
    val parkingLotId: Long,
    val code: SerialNumber = SerialNumber.generate(),
    val decision: AccessDecision,
    val licensePlate: LicensePlate,
    val src: String,
    val ts: LocalDateTime,
    val issuedAt: LocalDateTime = LocalDateTime.now().truncatedTo(SECONDS),
)
