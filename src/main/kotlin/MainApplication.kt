package com.fsl

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.web.servlet.ServletComponentScan
import java.lang.System.getProperty
import java.lang.System.getenv
import java.lang.System.setProperty

@SpringBootApplication
@ServletComponentScan
open class MainApplication

fun main(args: Array<String>) {
    SpringApplicationBuilder(MainApplication::class.java)
        .profiles(environment)
        .logStartupInfo(true)
        .build()
        .run(*args)
}

val environment: String = getProperty(
    "bring.env", getenv("SPRING_PROFILES_ACTIVE")
        ?: "dev"
).also { env ->
    setProperty("bring.env", env)
    setProperty("CONSTRETTO_TAGS", env)
}