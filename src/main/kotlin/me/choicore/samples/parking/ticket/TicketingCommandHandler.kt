package me.choicore.samples.parking.ticket

import org.springframework.stereotype.Service

@Service
interface TicketingCommandHandler<T : TicketingCommand> {
    fun validate(command: T) {}

    fun handle(command: T): Ticket

    val supports: Class<T>
}
