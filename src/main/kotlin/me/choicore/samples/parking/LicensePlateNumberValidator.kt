package me.choicore.samples.parking

import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext
import me.choicore.samples.parking.ticket.LicensePlateValidator

class LicensePlateNumberValidator : ConstraintValidator<LicensePlateNumber, String> {
    override fun isValid(
        value: String,
        context: ConstraintValidatorContext,
    ): Boolean = !LicensePlateValidator.matches(value)
}
