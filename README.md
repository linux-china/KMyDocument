Kotlin for MySQL document store
===============================


# Setup

Please use "docker-compose up -d" to start MySQL 8.

# Ports

* 3306: traditional
* 33060: X Protocol

# Document Store

* Schema: database name
* Collection: almost like table
* DbDoc: document
* id: name should be "_id" with String type
* jdbc url: mysqlx://127.0.0.1:33060/demo?user=root&password=password

# MySQL Shell

Login
```bash
mysqlsh --uri root@127.0.0.1
```
Operations in MySQL Shell

```
JS> \use demo
JS> db.createCollection("Account")
JS> db.get_collections()
JS> db.get_collections()
JS> db.Account.find()
```

* query: https://dev.mysql.com/doc/refman/8.0/en/mysql-shell-tutorial-javascript-documents-find.html

# Reference

* MySQL Shell: https://dev.mysql.com/doc/refman/5.7/en/mysql-shell.html
* Connector/J 8.0: https://dev.mysql.com/doc/connector-j/8.0/en/connector-j-whats-new.html
* Enable X Protocol: https://dev.mysql.com/doc/refman/5.7/en/document-store-setting-up.html
```
mysqlsh -u root -h 127.0.0.1 --classic --dba enableXProtocol
```
