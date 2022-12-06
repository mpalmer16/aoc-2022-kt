package day6

import org.junit.jupiter.api.Test
import java.io.File

class Day6Test {

    @Test
    fun `can read input`() {
        assert(input.length == 30);
    }

    @Test
    fun `can find marker`() {
        val (marker, count) = findMarker(input, 4)

        println("$marker, $count")
        assert(marker.isNotEmpty())
        assert(count == 7)
    }

    private val input = File("src/test/kotlin/day6/test_input.txt").readText()
}

