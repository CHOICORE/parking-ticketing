package me.choicore.samples.parking.ticket

import org.junit.jupiter.api.Test
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

class AutomaticTicketingCommandHandlerTests {
    @Test
    fun t1() {
        val automaticTicketingCommandHandler = AutomaticTicketingCommandHandler()

        val command =
            TicketingCommand.Automatic(
                complexId = 1L,
                parkingLotId = 2L,
                licensePlate = LicensePlate("123가1234"),
                src = "test",
                ts = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS),
            )
        automaticTicketingCommandHandler.handle(command)
    }
}
