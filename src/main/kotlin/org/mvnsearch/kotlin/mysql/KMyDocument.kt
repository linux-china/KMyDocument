package org.mvnsearch.kotlin.mysql

import com.mysql.cj.xdevapi.Session
import com.mysql.cj.xdevapi.SessionFactory

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