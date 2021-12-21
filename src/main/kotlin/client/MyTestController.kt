package com.fsl.client

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity.status
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MyTestController {
    @PostMapping("/put")
    fun addUser() = status(HttpStatus.OK).body("done")

}