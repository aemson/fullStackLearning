package com.fsl.controller

import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/kafka")
class AdminController(val kafkaTemplate: KafkaTemplate<String, String>,
                      @Value("\${topic.name}") val topicName: String) {

    @GetMapping("/users")
    fun getAdmin() {
        kafkaTemplate.send(topicName,"""{"consItemNo":"370730254969851113","eventCode":"YA"}""".trimIndent())
    }
}