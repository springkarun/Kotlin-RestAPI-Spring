package com.example.nk

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class NkApplication

fun main(args: Array<String>) {
    SpringApplication.run(NkApplication::class.java,*args)
}
