package etl

import java.sql.DriverManager
import java.sql.SQLException

fun main() {
    val host = System.getenv("DB_HOST")
    val user = System.getenv("DB_USER")
    val pass = System.getenv("DB_PASS")
    val db = System.getenv("DB_NAME")
    val connectionUrl = "jdbc:mysql://$host:3306/$db"

    try {
        DriverManager.getConnection(connectionUrl, user,pass).use { conn -> // use closes the connection
            conn.prepareStatement("SELECT * FROM user").use { ps ->
                ps.executeQuery().use { rs ->
                    while (rs.next()) {
                        val login = rs.getString("login")
                        println(login)
                    }
                }
            }
        }
    } catch (e: SQLException) {
        e.printStackTrace()
    }
}