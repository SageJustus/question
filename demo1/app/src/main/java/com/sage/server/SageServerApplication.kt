package com.sage.server

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SageServerApplication

fun main(args: Array<String>) {
    runApplication<SageServerApplication>(*args)
}
