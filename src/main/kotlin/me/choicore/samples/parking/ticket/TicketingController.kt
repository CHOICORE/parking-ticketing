package me.choicore.samples.parking.ticket

import jakarta.validation.Valid
import me.choicore.samples.parking.ResponseBody
import me.choicore.samples.parking.security.Credentials
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.temporal.ChronoUnit.SECONDS

@RestController
@RequestMapping("/v1/tickets")
class TicketingController(
    private val ticketingManager: TicketingManager,
) {
    @PostMapping
    fun automatic(
        @Valid
        @RequestBody
        request: TicketingRequest.Automatic,
        credentials: Credentials,
    ): Any {
        val ticket =
            ticketingManager.automatic(
                complexId = credentials.complexId,
                parkingLotId = credentials.parkingLotId,
                licensePlate = LicensePlate(number = request.lpn),
                src = request.src,
                ts = request.ts.truncatedTo(SECONDS),
            )

        return ResponseEntity.ok(ResponseBody.Item(data = TicketingResponse(ticket = ticket)))
    }
}
