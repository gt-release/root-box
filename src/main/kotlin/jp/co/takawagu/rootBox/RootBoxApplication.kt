package jp.co.takawagu.rootBox

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RootBoxApplication

fun main(args: Array<String>) {
    runApplication<RootBoxApplication>(*args)
}
