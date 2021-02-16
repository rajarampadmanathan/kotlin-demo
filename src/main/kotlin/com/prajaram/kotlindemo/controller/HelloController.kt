package com.prajaram.kotlindemo.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class HelloController {

    @GetMapping("/hello")
    fun sayHello(@RequestParam(defaultValue = "Raja") name: String, model: Model): String {
        model["user"]= name
        return "hello"
    }
}