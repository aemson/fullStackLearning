package com.fsl.domain

import java.time.ZonedDateTime
import java.time.ZonedDateTime.now

data class UserAdmin(
    val user_id: String,
    val user_name: String,
    val user_password: String? = "",
    val user_role: String,
    val created_at: ZonedDateTime = now(),
    val created_by: String = "admin"
) {
    constructor() : this("", "", "", "", now(), "")
}