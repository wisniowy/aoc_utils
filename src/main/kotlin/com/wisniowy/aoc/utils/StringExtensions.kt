package com.wisniowy.aoc.utils

fun String.toIntList(): List<Int> {
    return "-?\\d+".toRegex().findAll(this).map { it.value.toInt() }.toList()
}

fun String.toLongList(): List<Long> {
    return "-?\\d+".toRegex().findAll(this).map { it.value.toLong() }.toList()
}