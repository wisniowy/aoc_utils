package com.wisniowy.aoc.utils

fun <T> Sequence<T>.repeatIndefinitely(): Sequence<T> = sequence { while (true) yieldAll(this@repeatIndefinitely) }

fun <T> List<T>.repeatIndefinitely(): Sequence<T> = this.asSequence().repeatIndefinitely()

fun <T> Collection<T>.contentEquals(other: Collection<T>): Boolean {
    return this.size == other.size && this.zip(other).all { (x, y) -> x == y }
}