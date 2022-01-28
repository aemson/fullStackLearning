package com.fsl.controller

import arrow.core.Either
import com.fsl.service.UserDetailsService
import org.springframework.http.CacheControl.noCache
import org.springframework.http.HttpStatus.OK
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.status
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/welcome")
class WelcomeController(val userDetailsService: UserDetailsService) {

    @GetMapping("/users")
    fun getUsers(@RequestParam("userName", required = false) userName: String?): ResponseEntity<Any?> =
        userDetailsService.getUsers(userName).let {

            calculator(10, 20, add)
            calculator(100, 20, divide)
            calculator(10, 20) { x, y -> x * y }

            status(OK).cacheControl(noCache()).body(it)
        }

    fun getLambda():(acc: Int, ele: Int)-> Int ={ acc, ele ->
         acc + ele
    }
    val add: (Int, Int) -> Int = { x, y -> x + y }
    val divide: (Int, Int) -> Double = { x, y -> x.toDouble() + y.toDouble() }

    fun calculator(x: Int, y: Int, ƒ: (Int, Int) -> Number) {

        println(ƒ(x, y))
    }

    fun <T> callNoDeApi(ƒ: () -> T): Either<Throwable, T> =
        Either.catch {
            ƒ()
        }

}