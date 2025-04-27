package me.choicore.samples.parking.ticket

import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class TicketingManager(
    private val ticketingCommandHandler: TicketingCommandHandler<TicketingCommand>,
) {
    fun automatic(
        complexId: Long,
        parkingLotId: Long,
        licensePlate: LicensePlate,
        src: String,
        ts: LocalDateTime,
    ): Ticket {
        val command =
            TicketingCommand.Automatic(
                complexId = complexId,
                parkingLotId = parkingLotId,
                licensePlate = licensePlate,
                src = src,
                ts = ts,
            )

        return ticketingCommandHandler.handle(command)
    }
}
