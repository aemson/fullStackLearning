package com.fsl.helper

import java.util.Base64.getEncoder

fun String.encryptPassword(token: String) =
    getEncoder().encodeToString(("$this:$token".toByteArray()))