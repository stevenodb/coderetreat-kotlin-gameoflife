package be.swsb.coderetreat

class Universe(val livingCellPositions: Set<CellPosition>) {
    constructor(vararg livingCellPositions: CellPosition) : this(setOf(*livingCellPositions))

    fun tick(): Universe {
        val newLivingCells = livingCellPositions.filter { it.isAliveGiven(currentlyLiving = livingCellPositions) }.toSet()
        val deadCells = livingCellPositions.flatMap { it.neighbouringCells() } - livingCellPositions
        val birthedCells = deadCells.filter { it.neighbouringCells(onlyConsider = livingCellPositions).count() == 3 }.toSet()
        return Universe(newLivingCells + birthedCells)
    }
}