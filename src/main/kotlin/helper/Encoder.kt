package com.fsl.helper

import java.util.Base64.getEncoder

fun main() {
    val token  = getEncoder().encodeToString(( "helpdesk:helpDesk@User1".toByteArray() ))
    println(token)
}