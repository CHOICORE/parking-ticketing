package me.choicore.samples.parking.ticket

data class TicketingResponse(
    val code: SerialNumber,
) {
    constructor(ticket: Ticket) : this(code = ticket.code)
}
