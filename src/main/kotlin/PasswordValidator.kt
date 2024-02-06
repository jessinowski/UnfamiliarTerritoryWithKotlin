package com.github

object PasswordValidator {

    // Überprüft, ob alle Regeln eingehalten wurden
    fun isSafe(password: String): Boolean {
        return hasAtLeast8Chars(password) &&
                hasDigits(password) &&
                isUpperAndLowerCase(password) &&
                isNotCommonlyUsed(password) &&
                hasSpecialChars(password)
    }

    // Überprüft, ob das eingegebene Passwort mindestens 8 Zeichen lang ist
    fun hasAtLeast8Chars(password: String): Boolean {
        return password.length >= 8
    }

    // Überprüft, ob das eingegebene Passwort mindestens eine Ziffer enthält
    fun hasDigits(password: String): Boolean {
        return password.contains(Regex("\\d"))
    }

    // Überprüft, ob das Passwort Groß- und Kleinbuchstaben enthält
    fun isUpperAndLowerCase(password: String): Boolean {
        return password.contains(Regex("[a-z]")) && password.contains(Regex("[A-Z]"))
    }

    // Überprüft, ob das Passwort nicht üblicherweise verwendet wird
    fun isNotCommonlyUsed(password: String): Boolean {
        return !(password == "Password1") && !(password == "Aa345678")
    }

    // Überprüft, ob Sonderzeichen enthalten sind
    fun hasSpecialChars(password: String): Boolean {
        return password.contains(Regex("\\W"))
    }
}
