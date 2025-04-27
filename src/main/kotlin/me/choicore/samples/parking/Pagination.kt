package me.choicore.samples.parking

sealed interface Pagination<T> {
    data class Offset<T>(
        val size: Int,
        val number: Int,
        val totalElements: Int,
        val totalPages: Int,
        val items: List<T>,
    ) : Pagination<T>

    data class Cursor<T>(
        val size: Int,
        val current: String,
        val next: String?,
        val items: List<T>,
    ) : Pagination<T> {
        val hasNext: Boolean = next != null
    }
}
