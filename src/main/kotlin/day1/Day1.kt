package day1

import java.io.File

fun main() {
    val input = File("src/main/kotlin/day1/input.txt").readText()
    val sums = sumElfCalories(input)

    println("answer 1: ${sums.max()}")

    val sumOfTopThree = sumTopThree(sums)

    println("answer 2: $sumOfTopThree")
}

fun sumElfCalories(input: String) =
    input.split("\r\n\r\n")
        .map { elf -> elf.split("\r\n")
            .sumOf { it.toInt() }
        }


fun sumTopThree(sums: List<Int>) =
    sums.sortedDescending().take(3).sum()
