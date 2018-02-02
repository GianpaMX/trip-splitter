package io.github.gianpamx.tripsplitter.data

interface Repository<T> {
    fun create(item: T, success: () -> Unit, failure: (throwable: Throwable) -> Unit = { })
    fun retrieve(id: String, success: (item: T) -> Unit, failure: (throwable: Throwable) -> Unit = { })
    fun update(item: T, success: () -> Unit, failure: (throwable: Throwable) -> Unit = { })
    fun delete(id: String, success: () -> Unit, failure: (throwable: Throwable) -> Unit = { })

    fun retrieveAll(success: (items: List<T>) -> Unit, failure: (throwable: Throwable) -> Unit = { })

    class NotFoundException(message: String) : Exception(message)
}
