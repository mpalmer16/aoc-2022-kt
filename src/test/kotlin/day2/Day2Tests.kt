package day2

import day2.RPS.*
import org.junit.jupiter.api.Test
import java.io.File

class Day2Tests {

    @Test
    fun `can read the input file`() {
        val input = input

        assert(input.size == 3)
    }

    @Test
    fun `can get values`() {
        val result = getValuesRps(input)

        assert(result == listOf(
            Pair(ROCK, PAPER),
            Pair(PAPER, ROCK),
            Pair(SCISSORS, SCISSORS)
        ))
    }

    @Test
    fun `can get score for shape`() {
        val input = getValuesRps(input)
        val result = input.map(::scoreForShape)

        assert(result == listOf(2, 1, 3))
    }

    @Test
    fun `can get score for round`() {
        val input = getValuesRps(input)
        val result = input.map(::scoreForRound)

        assert(result == listOf(6, 0, 3))
    }

    @Test
    fun `can get score for game with rps`() {
        val input = getValuesRps(input)
        val result = score(input)

        assert(result == 15)
    }

    @Test
    fun `can get score for game with wld`() {
        val input = getValuesWld(input)
        val result = score(input.convert())

        assert(result == 12)
    }

    private val input = File("src/test/kotlin/day2/test_input.txt").readLines()
}