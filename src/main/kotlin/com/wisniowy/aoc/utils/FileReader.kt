package com.wisniowy.aoc.utils

import java.io.File
import java.io.FileNotFoundException

object FileReader {

    const val PART_SEPARATOR = "### PART SEPARATOR ###\n"
    enum class InputPart(val idx: Int) { PART_ONE(0), PART_TWO(1)}

    fun inputAsString(file: File, inputPart: InputPart = InputPart.PART_ONE) : String {
        val inputParts = file.readText().split(PART_SEPARATOR)

        return if (inputParts.size == 1) inputParts[InputPart.PART_ONE.idx].trim() else inputParts[inputPart.idx].trim()
    }

    fun inputAsStringList(file: File, inputPart: InputPart = InputPart.PART_ONE) : List<String> {
        val inputParts = file.readText().split(PART_SEPARATOR)

        return if (inputParts.size == 1) inputParts[InputPart.PART_ONE.idx].trim().lines()
            else inputParts[inputPart.idx].trim().lines()
    }

    internal fun loadFileFromResources(dayNumber: Int) : File {
        return File(javaClass.classLoader.getResource("input_day_$dayNumber.txt")?.toURI()
            ?: throw FileNotFoundException("File does not exist")
        )
    }

}