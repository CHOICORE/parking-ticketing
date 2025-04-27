package me.choicore.samples.parking.ticket

data class LicensePlate(
    val number: String,
    val image: String? = null,
) {
    init {
        require(LicensePlateValidator.matches(lpn = number)) {
            LicensePlateValidator.DEFAULT_MESSAGE
        }
    }

    override fun toString(): String = number
}
