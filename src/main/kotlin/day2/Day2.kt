package day2

import day2.RPS.*
import day2.WLD.*
import java.io.File


fun main() {
    val inputRps = getValuesRps(File("src/main/kotlin/day2/input.txt").readLines())
    val scoreRps = score(inputRps)

    println("answer 1: $scoreRps")

    val inputWld = getValuesWld(File("src/main/kotlin/day2/ingit put.txt").readLines())
    val scoreWld = score(inputWld.convert())

    println("answer 2: $scoreWld")
}

fun List<Pair<RPS, WLD>>.convert() =
    this.map {
        when (it.first) {
            ROCK -> when (it.second) {
                WIN -> it.first to PAPER
                LOSE -> it.first to SCISSORS
                DRAW -> it.first to ROCK
            }
            PAPER -> when (it.second) {
                WIN -> it.first to SCISSORS
                LOSE -> it.first to ROCK
                DRAW -> it.first to PAPER
            }
            SCISSORS -> when (it.second) {
                WIN -> it.first to ROCK
                LOSE -> it.first to PAPER
                DRAW -> it.first to SCISSORS
            }
        }
    }
enum class RPS {
    ROCK, PAPER, SCISSORS;

    companion object {
        fun from(s: String) =
            when (s) {
                "A", "X" -> ROCK
                "B", "Y" -> PAPER
                "C", "Z" -> SCISSORS
                else -> throw IllegalArgumentException("unknown value")
            }
    }
}

enum class WLD {
    WIN, LOSE, DRAW;

    companion object {
        fun from(s: String) =
            when (s) {
                "X" -> LOSE
                "Y" -> DRAW
                "Z" -> WIN
                else -> throw IllegalArgumentException("unknown value")
            }
    }
}

fun getValuesRps(input: List<String>) =
    input.map {s ->
        s.split(" ")
    }.map {
        Pair(RPS.from(it[0]), RPS.from(it[1]))
    }

fun getValuesWld(input: List<String>) =
    input.map {s ->
        s.split(" ")
    }.map {
        Pair(RPS.from(it[0]), WLD.from(it[1]))
    }

fun scoreForShape(round: Pair<RPS, RPS>) =
    when (round.second) {
        ROCK -> 1
        PAPER -> 2
        SCISSORS -> 3
    }

fun scoreForRound(round: Pair<RPS, RPS>) =
    when (round.first) {
        ROCK -> when (round.second) {
            ROCK -> 3
            PAPER -> 6
            SCISSORS -> 0
        }
        PAPER -> when (round.second) {
            ROCK -> 0
            PAPER -> 3
            SCISSORS -> 6
        }
        SCISSORS -> when (round.second) {
            ROCK -> 6
            PAPER -> 0
            SCISSORS -> 3
        }
    }

fun score(game: List<Pair<RPS, RPS>>) =
    game.sumOf { scoreForShape(it) + scoreForRound(it) }