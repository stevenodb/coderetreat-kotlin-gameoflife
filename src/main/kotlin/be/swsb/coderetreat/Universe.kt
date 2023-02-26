package be.swsb.coderetreat

class Universe(val livingCellPositions: Set<CellPosition>) {
    constructor(vararg livingCellPositions: CellPosition) : this(setOf(*livingCellPositions))

    fun tick(): Universe {
        val newLivingCells = livingCellPositions.filter { cell ->
            when (livingNeighbourCellCount(cell)) {
                in 0..1 -> false
                in 4..8 -> false
                else -> true
            }
        }.toSet()
        val deadCells = livingCellPositions.flatMap { it.neighbouringCells() } - livingCellPositions
        val birthedCells = deadCells.filter { livingNeighbourCellCount(it) == 3 }.toSet()
        return Universe(newLivingCells + birthedCells)
    }

    private fun livingNeighbourCellCount(cellPosition: CellPosition): Int =
        cellPosition.neighbouringCells { it in livingCellPositions }.count()
}

data class CellPosition(val x: Int, val y: Int) {

    fun neighbouringCells(filterFunction: (CellPosition) -> Boolean = { true }): List<CellPosition> {
        val allNeighbouringPositions =
            (-1..1)
                .flatMap { ny -> (-1..1)
                    .filterNot { nx -> nx == 0 && ny == 0 }
                    .map { nx -> CellPosition(nx, ny) } }
        return allNeighbouringPositions
            .map { this + it }
            .filter(filterFunction)
    }

    private operator fun plus(other: CellPosition) = CellPosition(x + other.x, y + other.y)
}