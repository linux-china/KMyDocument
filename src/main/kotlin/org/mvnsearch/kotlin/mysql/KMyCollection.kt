package org.mvnsearch.kotlin.mysql

import com.mysql.cj.xdevapi.Collection
import com.mysql.cj.xdevapi.DbDoc
import kotlin.reflect.KClass

/**
 * kotlin mysql Collection
 *
 * @author linux_china
 */
interface KMyCollection<T : Any> {
    fun save(value: T)

    fun findOne(id: String): T?

    fun find(condition: String): List<T>
}

class KMyCollectionImpl<T : Any>(private val collection: Collection, val kClazz: KClass<T>) : KMyCollection<T> {
    private val clazz = kClazz.java

    override fun findOne(id: String): T? {
        val doc = collection.getOne(id)
        if (doc == null || doc.isEmpty()) return null
        return convert(doc)
    }

    override fun save(value: T) {
        collection.add(klaxon.toJsonString(value)).execute()
    }

    override fun find(condition: String): List<T> {
        val docResult = collection.find(condition).execute()
        return docResult.map { convert(it) }.toList()
    }

    @Suppress("UNCHECKED_CAST")
    private fun convert(doc: DbDoc): T {
        return klaxon.fromJsonObject(
            klaxon.parseJsonObject(doc.toFormattedString().reader()),
            clazz,
            kClazz
        ) as T
    }
}