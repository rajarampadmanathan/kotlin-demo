package com.prajaram.kotlindemo.service

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class JokeServiceTest {

    @Autowired
    lateinit var jokeService: JokeService

    @Test
    internal fun `testGetJoke`() {
        val joke = jokeService.getJoke("Rajaram", "Padmanathan")
        println(joke)
        assert(joke.contains("Rajaram") || joke.contains("Padmanathan"))
    }
}