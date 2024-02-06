package com.github

import java.security.SecureRandom

object PasswordGenerator {

    private const val UPPER = " ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    private const val LOWER = "abcdefghijklmnopqrstuvwxyz"
    private const val DIGITS = "0123456789"
    private const val SPECIALS = "!@#$%^&*()-_+=<>?"

    fun generateSecurePassword(): String {
        val characters = UPPER + LOWER + DIGITS + SPECIALS

        val random = SecureRandom()
        val passwordBuilder = StringBuilder()

        repeat(8) {
            val randomIndex = random.nextInt(characters.length)
            passwordBuilder.append(characters[randomIndex])
        }

        val password = passwordBuilder.toString()

        if (PasswordValidator.hasDigits(password) &&
            PasswordValidator.isUpperAndLowerCase(password) &&
            PasswordValidator.isNotCommonlyUsed(password) &&
            PasswordValidator.hasSpecialChars(password)
        ) {
            return password
        }
        return generateSecurePassword()
    }
}
