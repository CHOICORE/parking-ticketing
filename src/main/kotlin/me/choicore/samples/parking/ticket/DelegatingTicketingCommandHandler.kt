package me.choicore.samples.parking.ticket

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Service

@Service
@Primary
class DelegatingTicketingCommandHandler(
    private val delegates: Map<Class<out TicketingCommand>, TicketingCommandHandler<out TicketingCommand>>,
) : TicketingCommandHandler<TicketingCommand> {
    override val supports: Class<TicketingCommand> = TicketingCommand::class.java

    @Autowired
    constructor(ticketingCommandHandler: List<TicketingCommandHandler<out TicketingCommand>>) : this(
        delegates = ticketingCommandHandler.associateBy { it.supports },
    )

    override fun handle(command: TicketingCommand): Ticket {
        log.debug("Delegating command: ${command::class.simpleName}")
        return determineTicketingCommandHandler(command).handle(command)
    }

    private fun determineTicketingCommandHandler(command: TicketingCommand): TicketingCommandHandler<TicketingCommand> {
        val ticketingCommandHandler: TicketingCommandHandler<out TicketingCommand> = (
            delegates[command::class.java]
                ?: throw IllegalStateException("No TicketingCommandHandler found for ${command::class.simpleName}")
        )
        return ticketingCommandHandler as TicketingCommandHandler<TicketingCommand>
    }

    companion object {
        private val log: Logger = LoggerFactory.getLogger(DelegatingTicketingCommandHandler::class.java)
    }
}
