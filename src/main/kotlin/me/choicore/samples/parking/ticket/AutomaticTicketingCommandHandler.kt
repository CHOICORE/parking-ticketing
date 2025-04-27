package me.choicore.samples.parking.ticket

import me.choicore.samples.parking.ticket.AccessDecision.ALLOWED
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class AutomaticTicketingCommandHandler : TicketingCommandHandler<TicketingCommand.Automatic> {
    override val supports: Class<TicketingCommand.Automatic> = TicketingCommand.Automatic::class.java

    override fun handle(command: TicketingCommand.Automatic): Ticket {
        val (
            complexId: Long,
            parkingLotId: Long,
            licensePlate: LicensePlate,
            src: String,
            ts: LocalDateTime,
        ) = command

        this.validate(command = command)

        return Ticket(
            complexId = complexId,
            parkingLotId = parkingLotId,
            decision = ALLOWED,
            licensePlate = licensePlate,
            src = src,
            ts = ts,
        )
    }

    override fun validate(command: TicketingCommand.Automatic) {
        LicensePlateValidator.validate(licensePlate = command.licensePlate)
    }
}
