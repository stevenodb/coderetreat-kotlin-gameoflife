package be.swsb.coderetreat

class Universe(val livingCells: List<Cell>) {

    fun tick(): Universe {
        val newLivingCells = livingCells.mapNotNull { cell ->
            when (livingNeighbourCount(cell)) {
                in 0..1 -> null
                in 4..8 -> null
                else -> cell
            }
        }.toList()
        val deadCells = livingCells.flatMap { neighbouringCells(it) } - livingCells.toSet()
        val birthedCells = deadCells.filter { livingNeighbourCount(it) == 3 }.toSet()
        return Universe(newLivingCells + birthedCells)
    }

    private fun neighbouringCells(cell: Cell): List<Cell> {
        val neighbouringPairs = (-1..1).flatMap { ny -> (-1..1).map { nx -> Cell(nx, ny) } } - (Cell(0, 0))
        return neighbouringPairs.map { cell + it }
    }

    private fun livingNeighbourCount(currentCell: Cell): Int =
        neighbouringCells(currentCell).count { it in livingCells }
}

data class Cell(val x: Int, val y: Int) {
    operator fun plus(other: Cell): Cell = Cell(this.x + other.x, this.y + other.y)
}