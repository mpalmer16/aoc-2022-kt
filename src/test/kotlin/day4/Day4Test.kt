package day4

import org.junit.jupiter.api.Test
import java.io.File

class Day4Test {

    @Test
    fun `can read input file`() {
        assert(input.size == 6)
    }

    @Test
    fun `can get section assignments`() {
        val sectionAssignments = input
            .map(List<String>::toSectionAssignments)

        assert(sectionAssignments.size == 6)
    }

    @Test
    fun `can find complete overlaps`() {
        val completeOverlaps = input
            .map(List<String>::toSectionAssignments)
            .filter(::overlapsCompletely)

        assert(completeOverlaps.size == 2)
    }

    @Test
    fun `can find partial overlaps`() {
        val partialOverlaps = input
            .map(List<String>::toSectionAssignments)
            .filter(::partialOverlaps)

        assert(partialOverlaps.size == 4)
    }

    private val input = File("src/test/kotlin/day4/test_input.txt").readLines().map { it.split(',') }
}