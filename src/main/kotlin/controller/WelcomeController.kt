package com.fsl.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class WelcomeController {
    @RequestMapping("/")
    fun welcome(): String = "Welcome to fullstackLearning App"

}