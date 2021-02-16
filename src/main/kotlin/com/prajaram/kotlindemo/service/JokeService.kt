package com.prajaram.kotlindemo.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.stereotype.Service
import org.springframework.web.client.getForObject
import java.net.UnknownHostException

@Service
class JokeService(@Autowired private val builder: RestTemplateBuilder) {

    private val restTemplate = builder.build()

    companion object {
        const val BASE_URL = "http://api.icndb.com/jokes/random?limitTo=[nerdy]"
    }

    fun getJoke(firstName: String, lastName: String) =
            try {
                restTemplate.getForObject<JokeResponse>("$BASE_URL&firstName=$firstName&lastName=$lastName").value.joke
            } catch (e: UnknownHostException) {
                "No joke available...."
            }
}


data class Joke(val id: Int,
                val joke: String,
                val categories: List<String>)

data class JokeResponse(val type: String,
                        val value: Joke)