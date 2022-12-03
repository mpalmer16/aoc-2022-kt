package day3

import org.junit.jupiter.api.Test
import java.io.File

class Day3Tests {

    @Test
    fun `can read the input file`() {
        assert(input.size == 6)
    }

    @Test
    fun `can get part one`() {
        assert(157 == input
            .asSequence()
            .map { it.chunked(it.length / 2) }
            .map { it.component1().find { c -> c in it.component2() } }
            .sumOf { letters.indexOf(it) + 1 }
        )
    }

    @Test
    fun `can get part two`() {
        assert(70 == input
            .chunked(3)
            .map { it.component1().find { c -> c in it.component2() && c in it.component3() } }
            .sumOf { letters.indexOf(it) + 1 }
        )
    }

    private val letters = ('a'..'z') + ('A'..'Z')
    private val input = File("src/test/kotlin/day3/test_input.txt").readLines()
}