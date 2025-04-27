package me.choicore.samples.parking.ticket

import java.time.LocalDateTime

sealed interface TicketingCommand {
    val complexId: Long
    val parkingLotId: Long
    val src: String
    val ts: LocalDateTime

    data class Automatic(
        override val complexId: Long,
        override val parkingLotId: Long,
        val licensePlate: LicensePlate,
        override val src: String,
        override val ts: LocalDateTime,
    ) : TicketingCommand
}
