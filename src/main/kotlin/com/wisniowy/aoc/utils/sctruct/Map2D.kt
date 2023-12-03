package com.wisniowy.aoc.utils.sctruct

class Map2D<E> {

    companion object {
        private val ADJACENCY_DIRECTIONS = listOf(
            Point2D(-1, 0), Point2D(1, 0 ), Point2D(0, -1), Point2D(0, 1)
        )

        private val ADJACENCY_DIRECTIONS_DIAGONALLY = listOf(
            Point2D(-1, 0), Point2D(-1, -1), Point2D(0, -1), Point2D(-1, -1),
            Point2D(1, 0), Point2D(1, 1), Point2D(0, 1), Point2D(-1, 1),
        )

        fun <E> fromString(s: String): Map2D<E> {
            val map2d = Map2D<E>()

            s.lines().forEachIndexed { y, line -> line.forEachIndexed { x, value ->
                map2d.addPoint(Point2D(x, y), value as E)
            } }

            return map2d
        }
    }

    val points: MutableMap<Point2D, E> = mutableMapOf()

    var width: Int = 0
    var height: Int = 0

    fun addPoint(point: Point2D, e: E) {
        points[point] = e
        width = maxOf(point.x + 1, width)
        height = maxOf(point.y + 1, height)
    }

    fun getPoint(point2D: Point2D): E {
        return points[point2D] ?: throw IllegalArgumentException("Point does not exist")
    }
    fun getWidth(): Int {
        return width
    }

    fun getHeight(): Int {
        return height
    }

    fun getAdjacentPoints(point: Point2D, diagonally: Boolean = false) : List<Point2D> {
        return if (diagonally) {
            ADJACENCY_DIRECTIONS_DIAGONALLY.map { adjacentPoint -> adjacentPoint + point }
                .filter { point2D -> point.x < width && point.y < height }
        } else {
            ADJACENCY_DIRECTIONS.map { adjacentPoint -> adjacentPoint + point }
                .filter { point2D -> point.x < width && point.y < height }
        }
    }
}