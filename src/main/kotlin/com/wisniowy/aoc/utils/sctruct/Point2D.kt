package com.wisniowy.aoc.utils.sctruct

data class Point2D(val x: Int, val y: Int) {

    operator fun plus(point2D: Point2D) : Point2D {
        return Point2D(x + point2D.x, y + point2D.y)
    }
}