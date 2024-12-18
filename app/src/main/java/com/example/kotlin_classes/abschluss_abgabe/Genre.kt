package com.example.kotlin_classes.abschluss_abgabe

enum class Genre (val description: String) {
    FICTION("Fictional stories and novels"),
    NON_FICTION("Non-fictional, real-world stories"),
    SCIENCE("Scientific and educational"),
    HISTORY("Historical events and accounts"),
    CHILDREN("Books for children");

    fun printDescription() {
        println(description)
    }
}