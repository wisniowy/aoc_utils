package com.wisniowy.aoc.utils.math

import kotlin.math.max

fun lcm(a: Int, b: Int) : Int {
    val maxValue = max(a, b)
    val maxLcm = a * b
    var lcm = maxValue
    while (lcm <= maxLcm) {
        if (lcm % a == 0 && lcm % b == 0) return lcm
        lcm += maxValue
    }
    return maxLcm
}

fun lcm(a: Long, b: Long) : Long {
    val maxValue = max(a, b)
    val maxLcm = a * b
    var lcm = maxValue
    while (lcm <= maxLcm) {
        if (lcm % a == 0L && lcm % b == 0L) return lcm
        lcm += maxValue
    }
    return maxLcm
}

fun Sequence<Int>.lcm(): Int = this.reduce { acc, i -> lcm(acc, i) }
fun List<Int>.lcm(): Int = this.reduce { acc, i -> lcm(acc, i) }

fun Sequence<Long>.lcm(): Long = this.reduce { acc, i -> lcm(acc, i) }
fun List<Long>.lcm(): Long = this.reduce { acc, i -> lcm(acc, i) }