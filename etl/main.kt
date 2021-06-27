package etl

import java.sql.DriverManager
import java.sql.SQLException
import java.util.*


fun main() {
    val sqlSelectAllPersons = "SELECT * FROM person"
    val connectionUrl = "jdbc:mysql://mysql-2678aa21-domrevigor-079c.aivencloud.com:17474/defaultdb"

    try {
        val properties = Properties()
        DriverManager.getConnection(connectionUrl, "avnadmin","aas03ic8d34aua25").use { conn ->
            conn.prepareStatement(sqlSelectAllPersons).use { ps ->
                ps.executeQuery().use { rs ->
                    while (rs.next()) {
                        val id = rs.getLong("ID")
                        val name = rs.getString("FIRST_NAME")
                        val lastName = rs.getString("LAST_NAME")

                        // do something with the extracted data...
                    }
                }
            }
        }
    } catch (e: SQLException) {
        // handle the exception
    }
}