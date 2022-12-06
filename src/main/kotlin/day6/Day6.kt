package day6

import java.io.File

fun main() {

    val input = File("src/main/kotlin/day6/input.txt").readText()

    val answer1 = findMarker(input, 4)
    val answer2 = findMarker(input, 14)

    println("answer 1: $answer1, answer 2: $answer2")
}

fun findMarker(input: String, length: Int): Pair<String, Int> {
    input.windowed(length, 1).forEachIndexed { i, str ->
        if (str.toSortedSet().size == str.length) {
            return Pair(str, i + length)
        }
    }
    return Pair("", 0)
}
