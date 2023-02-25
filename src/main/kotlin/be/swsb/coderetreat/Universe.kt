package be.swsb.coderetreat

class Universe(val livingCells: Set<Cell>) {
    constructor(vararg livingCell:Cell): this(livingCell.toSet())

    fun tick(): Universe {
        val newLivingCells = livingCells.filter { cell ->
            when (livingNeighbourCellCount(cell)) {
                in 0..1 -> false
                in 4..8 -> false
                else -> true
            }
        }.toSet()
        val deadCells = livingCells.flatMap { neighbouringCells(it) } - livingCells
        val birthedCells = deadCells.filter { livingNeighbourCellCount(it) == 3 }.toSet()
        return Universe(newLivingCells + birthedCells)
    }

    private fun neighbouringCells(cell: Cell): List<Cell> {
        val neighbouringPairs = (-1..1).flatMap { ny -> (-1..1).map { nx -> Cell(nx, ny) } } - (Cell(0, 0))
        return neighbouringPairs.map { cell + it }
    }

    private fun livingNeighbourCellCount(currentCell: Cell): Int =
        neighbouringCells(currentCell).count { it in livingCells }
}

data class Cell(val x: Int, val y: Int) {
    operator fun plus(other: Cell): Cell = Cell(this.x + other.x, this.y + other.y)
}