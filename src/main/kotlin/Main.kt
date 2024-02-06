package com.github

import java.util.*

fun main() {
    primNumber()
}

fun enterPassword(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    var input: String

    println("Enter password:\n(Press '?' to generate random password)")
    input = scanner.nextLine()

    if (PasswordValidator.isSafe(input)) {
        println("Password validated")
    } else if (input == "?") {
        input = PasswordGenerator.generateSecurePassword()
        println(input)
    } else {
        println("Password not validated")
    }
}

