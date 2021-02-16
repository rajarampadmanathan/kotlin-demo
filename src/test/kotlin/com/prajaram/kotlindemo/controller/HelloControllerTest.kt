package com.prajaram.kotlindemo.controller

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.validation.support.BindingAwareModelMap


@WebMvcTest(HelloController::class)
class HelloControllerTest() {

    @Autowired
    lateinit var mvc:MockMvc

    @Test
    fun `test hello`() {
        val controller = HelloController()
        val model = BindingAwareModelMap()
        val result = controller.sayHello("Rajaram", model)
        assertAll(
                { Assertions.assertEquals("hello", result) },
                { Assertions.assertEquals("Rajaram", model["user"]) }
        )

    }

    @Test
    fun `test mock mvc`(){
        mvc.get("/hello"){
            accept= MediaType.TEXT_PLAIN
        }.andExpect {
            status { isOk() }
            view { name("hello") }
            model { attribute("user", "Raja") }
        }
    }

}