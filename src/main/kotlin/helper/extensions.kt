package com.fsl.helper

import arrow.core.Either
import arrow.core.Validated
import java.util.Base64.getEncoder

fun String.encryptPassword(token: String) =
    getEncoder().encodeToString(("$this:$token".toByteArray()))

fun <A> Either<*, A>.getU(): A = this.fold(
    { f -> if (f is Throwable) throw f else nope(this.toString()) },
    { f -> f }
)

fun <A> Validated<*, A>.getU(): A = this.toEither().getU()

fun nope(msg: String = ""): Nothing = throw Exception("This should never happen! $msg")
