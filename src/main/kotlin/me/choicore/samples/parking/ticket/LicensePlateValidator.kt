package me.choicore.samples.parking.ticket

object LicensePlateValidator {
    fun validate(licensePlate: LicensePlate) {
        val matches: Boolean =
            LicensePlateNumberPattern.entries.any {
                it.pattern.matches(licensePlate.number)
            }

        require(matches) { DEFAULT_MESSAGE }
    }

    fun matches(lpn: String): Boolean {
        if (lpn.isBlank()) return false
        return LicensePlateNumberPattern.entries.any { it.pattern.matches(lpn) }
    }

    enum class LicensePlateNumberPattern(
        val pattern: Regex,
    ) {
        NORMAL(Regex("^\\d{2,3}[가-힣]\\d{4}\$")),
        REGIONAL(Regex("^[가-힣]{2}\\d{2}[가-힣]\\d{4}\$")),
    }

    const val DEFAULT_MESSAGE = "올바른 차량 번호를 입력해주세요."
}
