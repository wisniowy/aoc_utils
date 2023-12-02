package com.wisniowy.aoc.utils

import java.io.File
import java.io.FileNotFoundException

object FileReader {

    fun inputAsString(file: File) : String {
        return file.readText()
    }

    fun inputAsStringList(file: File) : List<String> {
        return file.readLines()
    }

    internal fun loadFileFromResources(dayNumber: Int) : File {
        return File(javaClass.classLoader.getResource("input_day_$dayNumber.txt")?.toURI()
            ?: throw FileNotFoundException("File does not exist")
        )
    }

}