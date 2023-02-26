package be.swsb.coderetreat

class Universe(val livingCellPositions: List<CellPosition>) {
    constructor(vararg livingCellPositions: CellPosition) : this(livingCellPositions.asList())

    fun tick(): Universe {
        val cellsToConsider = livingCellPositions.flatMap { it.neighbouringCells() }.distinct()
        val newLivingCells = cellsToConsider.filter { it.isAliveNextGiven(currentlyLiving = livingCellPositions) }.distinct()
        return Universe(newLivingCells)
    }
}