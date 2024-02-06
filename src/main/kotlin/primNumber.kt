package com.github

fun primNumber() {
    println("Hello World!")
    val n = 10 // Ändere dies, um eine unterschiedliche Anzahl von Primzahlen zu generieren
    val primzahlenListe = generierePrimzahlen(n)
    println("Die ersten $n Primzahlen lauten: $primzahlenListe")
}
fun generierePrimzahlen(n: Int): List<Int> {
    require(n > 0) { "n muss eine positive Ganzzahl sein" }
    val primzahlen = mutableListOf<Int>()

    var nummer = 2
    while (primzahlen.size < n) {
        if (istPrimzahl(nummer)) {
            primzahlen.add(nummer)
        }
        nummer++
    }
    return primzahlen
}

fun istPrimzahl(nummer: Int): Boolean {
    if (nummer <= 1) return false
    if (nummer == 2 || nummer == 3) return true
    if (nummer % 2 == 0 || nummer % 3 == 0) return false

    var i = 5
    while (i * i <= nummer) {
        if (nummer % i == 0 || nummer % (i + 2) == 0) {
            return false
        }
        i += 6
    }
    return true
}