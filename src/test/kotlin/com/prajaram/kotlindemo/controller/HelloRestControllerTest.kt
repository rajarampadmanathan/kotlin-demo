package com.prajaram.kotlindemo.controller

import org.hamcrest.Matchers
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.post

@WebMvcTest(HelloRestController::class)
class HelloRestControllerTest {

    @Autowired
    lateinit var mvc: MockMvc

    @Test
    fun `hello rest controller say hello`() {
        mvc.get("/hello-json") {
            accept(MediaType.APPLICATION_JSON)
        }.andExpect {
            status { isOk() }
        }.andExpect {
            jsonPath("$.message", Matchers.equalTo("Raja"))
        }
    }

    @Test
    fun `post and get greetings`() {
        mvc.post("/hello-json") {
            accept(MediaType.APPLICATION_JSON)
        }.andExpect {
            status { isOk() }
        }.andExpect {
            jsonPath("$.message", Matchers.equalTo("Raja"))
        }
    }
}