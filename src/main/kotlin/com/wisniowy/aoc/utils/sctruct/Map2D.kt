package com.wisniowy.aoc.utils.sctruct

class Map2D<E> {

    enum class AdjacencyDirections(val vector: Vector2D) {
        NORTH(Vector2D(0, 1)),
        NORTH_EAST(Vector2D(1, 1)),
        EAST(Vector2D(1, 0)),
        SOUTH_EAST(Vector2D(1, -1)),
        SOUTH(Vector2D(0, -1)),
        SOUTH_WEST(Vector2D(-1, -1)),
        WEST(Vector2D(-1, 0)),
        NORTH_WEST(Vector2D(-1, 1))
    }


    companion object {
        val ADJACENCY_DIRECTIONS = listOf(
            AdjacencyDirections.NORTH, AdjacencyDirections.EAST, AdjacencyDirections.SOUTH, AdjacencyDirections.WEST
        )

        val ADJACENCY_DIRECTIONS_DIAGONALLY = AdjacencyDirections.entries.toList()

        fun <E> fromString(s: String): Map2D<E> {
            val map2d = Map2D<E>()

            s.lines().reversed().forEachIndexed { y, line -> line.forEachIndexed { x, value ->
                map2d.addPoint(Point2D(x, y), value as E)
            } }

            return map2d
        }
    }

    private val points: MutableMap<Point2D, E> = mutableMapOf()
    private var width: Int = 0
    private var height: Int = 0

    fun addPoint(point: Point2D, e: E) {
        points[point] = e
        width = maxOf(point.x + 1, width)
        height = maxOf(point.y + 1, height)
    }

    fun getPoints(): Map<Point2D, E> {
        return points
    }

    fun getPoint(point2D: Point2D): E? {
        return points[point2D]
    }

    fun getAdjacentPoints(point: Point2D, diagonally: Boolean = false) : List<Point2D> {
        return if (diagonally) {
            ADJACENCY_DIRECTIONS_DIAGONALLY.map { adjacencyDirection -> point + adjacencyDirection.vector }
                .filter { point2D -> point.x < width && point.y < height }
        } else {
            ADJACENCY_DIRECTIONS.map { adjacencyDirection -> point + adjacencyDirection.vector }
                .filter { point2D -> point.x < width && point.y < height }
        }
    }

    override fun toString(): String {
        val stringBuilder = StringBuilder()

        (0..< height).forEach { y ->
            (0..< width).forEach { x ->
                stringBuilder.append(points[Point2D(x, y)])
            }
            stringBuilder.append("\n")
        }

        return stringBuilder.toString()
    }
}