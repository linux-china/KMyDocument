package org.mvnsearch.kotlin.mysql

import com.mysql.cj.xdevapi.Session
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import java.util.*

/**
 * Kotlin MySQL document test
 *
 * @author linux_china
 */
data class Account(val _id: String = UUID.randomUUID().toString(), val nick: String)

class KMyDocumentTest {
    lateinit var session: Session
    lateinit var accountCollection: KMyCollection<Account>
    @BeforeAll
    fun setUp() {
        session = KMyDocument.session("mysqlx://127.0.0.1:33060/demo?user=root&password=123456")
        val schema = session.defaultSchema
        accountCollection = schema.getCollection<Account>()
    }

    @AfterAll
    fun tearDown() {
        session.close()
    }

    @Test
    fun testInsert() {
        accountCollection.save(Account("1", "jackie"))
    }

    @Test
    fun testGet() {
        val account = accountCollection.findOne("1")
        println(account?.nick)
    }

    @Test
    fun testSearch() {
        val account = accountCollection.find("_id = '1' and nick = 'jackie'")
        println(account.size)
    }
}