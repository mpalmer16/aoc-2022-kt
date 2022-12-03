package day3

import java.io.File

fun main() {
    val input = File("src/main/kotlin/day3/input.txt").readLines()
    val letters = ('a'..'z') + ('A'..'Z')

    val answer1 = input
        .asSequence()
        .map { it.chunked(it.length / 2) }
        .map { it.component1().find { c -> c in it.component2() } }
        .sumOf { letters.indexOf(it) + 1 }

    println("answer 1: $answer1")

    val answer2 = input
        .asSequence()
        .chunked(3)
        .map { it.component1().find { c -> c in it.component2() && c in it.component3() } }
        .sumOf { letters.indexOf(it) + 1 }

    println("answer 2: $answer2")
}