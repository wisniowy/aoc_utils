package com.wisniowy.aoc.utils

import java.io.File

abstract class SolutionDay(val dayNumber: Int) {

    protected val file: File

    init {
        file = FileReader.loadFileFromResources(dayNumber)
    }

    abstract fun partOne() : Any

    abstract fun partTwo() : Any

    protected fun inputAsString(inputPart: FileReader.InputPart = FileReader.InputPart.PART_ONE) : String {
        return FileReader.inputAsString(file, inputPart)
    }

    protected fun inputAsStringList(inputPart: FileReader.InputPart = FileReader.InputPart.PART_ONE): List<String> {
        return FileReader.inputAsStringList(file, inputPart)
    }
}