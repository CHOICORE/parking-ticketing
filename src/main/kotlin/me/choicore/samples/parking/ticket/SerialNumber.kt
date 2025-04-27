package me.choicore.samples.parking.ticket

import java.util.UUID

@JvmInline
value class SerialNumber(
    val code: String,
) {
    companion object {
        fun generate(): SerialNumber = SerialNumber(code = UUID.randomUUID().toString().replace("-", ""))
    }
}
