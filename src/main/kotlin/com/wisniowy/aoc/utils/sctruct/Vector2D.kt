package com.wisniowy.aoc.utils.sctruct

data class Vector2D(val x: Int, val y: Int) {

    operator fun times(multiplier: Int): Vector2D {
        return Vector2D(x * multiplier, y * multiplier)
    }
}