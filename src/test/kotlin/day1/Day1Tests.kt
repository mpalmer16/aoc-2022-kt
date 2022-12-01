package day1

import org.junit.jupiter.api.Test
import java.io.File

class Day1Tests {

    @Test
    fun `can sum elf calories`() {
        val sums = sumElfCalories(testInput())

        assert(sums.max() == 24000)
    }

    @Test
    fun `can sum top three`() {
        val sums = sumElfCalories(testInput())
        val sumOfTopThree = sumTopThree(sums)

        assert(sumOfTopThree == 45000)
    }

    private fun testInput() = File("src/test/kotlin/day1/test_input.txt").readText()
}