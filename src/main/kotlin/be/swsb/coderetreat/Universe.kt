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
        cellPosition.neighbouringCells().count{ it in livingCellPositions }
}