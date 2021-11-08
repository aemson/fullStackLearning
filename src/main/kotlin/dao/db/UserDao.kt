package com.fsl.dao.db

import com.fsl.domain.UserAdmin
import org.jdbi.v3.core.Handle
import org.jdbi.v3.core.Jdbi
import org.jdbi.v3.core.statement.Query
import org.springframework.stereotype.Component
import java.sql.ResultSet

@Component
class UserDao(private val fullStackAppDbi: Jdbi) {

    fun getUsers(role: String = "USER", userName: String?): List<UserAdmin> =
        openConnection { transaction ->
            var query = "select user_id, user_name, user_role from user_admin where user_role = :role";
            if (userName?.isNotBlank()!!)
                query += " and user_name = :username"
            val bind: Query = transaction
                .createQuery(query)
                .bind("role", role)

            if (userName.isNotBlank())
                bind.bind("username", userName)

            bind.map { resultSet, _, _ -> translateRequest(resultSet) }
                .list()


        }

    private fun translateRequest(resultSet: ResultSet): UserAdmin =
        UserAdmin(
            user_id = resultSet.getString("user_id"),
            user_name = resultSet.getString("user_name"),
            user_role = resultSet.getString("user_role"),
        )

    private fun <T> openConnection(query: (Handle) -> T): T = fullStackAppDbi.open().use { query(it) }
}