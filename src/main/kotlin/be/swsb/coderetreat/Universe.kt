package be.swsb.coderetreat

class Universe(val livingCellPositions: List<CellPosition>) {
    constructor(vararg livingCellPositions: CellPosition) : this(livingCellPositions.asList())

    fun tick(): Universe {
        val cellsToConsider = unionCellPositionsFor(livingCellPositions)
        val newLivingCells = cellsToConsider.filter { it.isAliveNext(currentlyLiving = livingCellPositions) }.distinct()
        return Universe(newLivingCells)
    }
}