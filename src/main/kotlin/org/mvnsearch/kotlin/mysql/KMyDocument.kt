package org.mvnsearch.kotlin.mysql

import com.beust.klaxon.Klaxon
import com.mysql.cj.xdevapi.Collection
import com.mysql.cj.xdevapi.Schema
import com.mysql.cj.xdevapi.Session
import com.mysql.cj.xdevapi.SessionFactory

val klaxon = Klaxon()

inline fun <reified T> Schema.getCollection(): Collection {
    return getCollection(T::class.simpleName)
}

fun Collection.insertOne(value: Any) {
    add(klaxon.toJsonString(value))
}

/**
 * Kotlin MySQL Document
 *
 * @author linux_china
 */
object KMyDocument {
    /**
     * create mysql session
     *
     * @param mysqlxUrl mysqlx url
     * @return the mysql session
     */
    fun session(mysqlxUrl: String): Session {
        return SessionFactory().getSession(mysqlxUrl);
    }

}