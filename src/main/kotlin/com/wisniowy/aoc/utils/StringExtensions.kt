package com.wisniowy.aoc.utils

fun String.strToIntList(str: String): List<Int> {
    return "\\d+".toRegex().findAll(str).map { it.value.toInt() }.toList()
}

fun String.strToLongList(str: String): List<Long> {
    return "\\d+".toRegex().findAll(str).map { it.value.toLong() }.toList()
}