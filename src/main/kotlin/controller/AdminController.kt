package com.fsl.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/admin")
class AdminController {
    @GetMapping("/users")
    fun getAdmin() = " HEllo i am admin"
}