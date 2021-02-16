package com.prajaram.kotlindemo

import com.prajaram.kotlindemo.controller.Greeting
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import kotlin.coroutines.coroutineContext

@SpringBootApplication
class KotlinDemoApplication

suspend fun main(args: Array<String>) {
	println(Greeting("Raja")==Greeting("Raja"))
	runApplication<KotlinDemoApplication>(*args)
	println("Hello ${testCoroutine()!!.toString()}")
}

suspend fun testCoroutine()= coroutineScope{
	for(i in 0..10){
		launch {
			delay(1000L - i*10)
			print(Thread.currentThread().id)
		}
	}
}
