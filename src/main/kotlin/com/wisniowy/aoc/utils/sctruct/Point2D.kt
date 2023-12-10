package com.wisniowy.aoc.utils.sctruct

data class Point2D(val x: Int, val y: Int) {

    operator fun plus(vector2D: Vector2D) : Point2D {
        return Point2D(x + vector2D.x, y + vector2D.y)
    }
}