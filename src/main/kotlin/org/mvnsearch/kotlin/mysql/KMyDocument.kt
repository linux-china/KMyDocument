package org.mvnsearch.kotlin.mysql

import com.beust.klaxon.Klaxon
import com.mysql.cj.xdevapi.Schema
import com.mysql.cj.xdevapi.Session
import com.mysql.cj.xdevapi.SessionFactory

val klaxon = Klaxon()

inline fun <reified T : Any> Schema.getCollection(): KMyCollection<T> {
    val collection = getCollection(T::class.simpleName)
    return KMyCollectionImpl(collection, T::class)
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