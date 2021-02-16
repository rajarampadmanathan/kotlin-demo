package com.prajaram.kotlindemo.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloRestController{

    private val greetings = mutableListOf<Greeting>()

    @GetMapping("/hello-json")
    fun sayHello(@RequestParam(required = false) name:String?):Greeting {
       return Greeting(name?:"Raja")
    }

    @GetMapping("/greetings")
    fun list()= greetings


    @PostMapping("/greetings")
    fun addGreetings(greeting: Greeting): Greeting{
        greetings.add(greeting)
        return greeting
    }
}

data class Greeting(val message: String="Rajaram"){
    override fun equals(other: Any?): Boolean {
        if(this === other) return true
        if(javaClass != other?.javaClass) return false
        other as Greeting
        return message == other.message
    }
}