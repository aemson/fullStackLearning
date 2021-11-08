package com.fsl.controller

import com.fsl.service.UserDetailsService
import org.springframework.http.CacheControl.noCache
import org.springframework.http.HttpStatus.OK
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.status
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class WelcomeController(val userDetailsService: UserDetailsService) {
    @RequestMapping("/")
    fun welcome(): String = "Welcome to fullstackLearning App"


    @RequestMapping("/users")
    fun getUsers(@RequestParam("userName", required = false) userName: String?): ResponseEntity<Any?> =
        userDetailsService.getUsers(userName).let {
            status(OK).cacheControl(noCache()).body(it)
        }

}