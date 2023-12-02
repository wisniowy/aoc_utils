package com.wisniowy.aoc.utils

import java.io.File

abstract class SolutionDay(val dayNumber: Int) {

    protected val file: File

    init {
        file = FileReader.loadFileFromResources(dayNumber)
    }

    abstract fun partOne() : Any

    abstract fun partTwo() : Any

    protected fun inputAsString() : String {
        return FileReader.inputAsString(file)
    }

    protected fun inputAsStringList(): List<String> {
        return FileReader.inputAsStringList(file)
    }
}