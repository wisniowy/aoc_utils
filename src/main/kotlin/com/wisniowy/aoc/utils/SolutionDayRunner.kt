package com.wisniowy.aoc.utils

import org.reflections.Reflections
import kotlin.system.measureTimeMillis

object SolutionDayRunner {

    data class Result(val result: Any, val measuredTime: Long)

    private const val ROW_FORMAT = "%-10s %-15s %-15s %-15s %s"

    fun run(packageToScan: String, dayNumber: Int? = null) {
        val reflections = Reflections(packageToScan)

        println(String.format(ROW_FORMAT, "Day", "Part One", "Time", "Part Two", "Time"))
        if (dayNumber == null) {
            reflections.getSubTypesOf(SolutionDay::class.java)
                .map { it.constructors[0].newInstance() as SolutionDay}
                .sortedBy { it.dayNumber }
                .forEach { solve(it) }
        } else {
            reflections.getSubTypesOf(SolutionDay::class.java)
                .filter { it.simpleName.equals("SolutionDay$dayNumber") }
                .map { it.constructors[0].newInstance() as SolutionDay}
                .map { solve(it) }
        }
    }

    private fun solve(sol: SolutionDay) {
        val partOneResult = measureTime { sol.partOne() }
        val partTwoResult = measureTime { sol.partTwo() }

        println(String.format(ROW_FORMAT, sol.dayNumber,
            if (partOneResult.result.toString().length <= 15) partOneResult.result.toString() else "<TLDR>",
            "${partOneResult.measuredTime} ms",
            if (partTwoResult.result.toString().length <= 15) partTwoResult.result.toString() else "<TLDR>",
            "${partTwoResult.measuredTime} ms"))
    }

    private fun measureTime(solutionFunction: () -> Any): Result {
        lateinit var result: Any
        val time = measureTimeMillis {
            result = solutionFunction.invoke()
        }

        return Result(result, time)
    }
}