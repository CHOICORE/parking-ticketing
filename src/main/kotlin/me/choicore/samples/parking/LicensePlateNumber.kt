package me.choicore.samples.parking

import jakarta.validation.Constraint
import jakarta.validation.Payload
import me.choicore.samples.parking.ticket.LicensePlateValidator
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [LicensePlateNumberValidator::class])
annotation class LicensePlateNumber(
    val message: String = LicensePlateValidator.DEFAULT_MESSAGE,
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = [],
)
