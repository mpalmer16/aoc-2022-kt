package day4

import java.io.File

typealias SectionAssignment = Pair<Pair<Int, Int>, Pair<Int, Int>>

fun main() {
    val input = File("src/main/kotlin/day4/input.txt")
        .readLines()
        .map { it.split(',') }
        .map(List<String>::toSectionAssignments)

    val completeOverlaps = input.filter(::overlapsCompletely).size
    val partialOverlaps = input.filter(::partialOverlaps).size

    println("answer 1: $completeOverlaps; answer 2: $partialOverlaps")
}

fun overlapsCompletely(sa: SectionAssignment) =
    sa.first.first <= sa.second.first &&
            sa.first.second >= sa.second.second ||
            sa.second.first <= sa.first.first &&
            sa.second.second >= sa.first.second

fun partialOverlaps(sa: SectionAssignment) =
    sa.ranges.first.any { sa.ranges.second.contains(it) }

fun List<String>.toSectionAssignments(): SectionAssignment {
    check(this.size == 2) { "invalid section pair" }
    return Pair(this[0].split('-').toIntPair(), this[1].split('-').toIntPair())
}

fun List<String>.toIntPair(): Pair<Int, Int> {
    check(this.size == 2) { "invalid section assignment" }
    return Pair(this[0].toInt(), this[1].toInt())
}

val Pair<Pair<Int, Int>, Pair<Int, Int>>.ranges
    get() = Pair((this.first.first..this.first.second), (this.second.first..this.second.second))
