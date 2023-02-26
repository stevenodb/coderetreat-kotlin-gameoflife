package be.swsb.coderetreat

data class CellPosition(val x: Int, val y: Int) {

    fun isAliveNext(currentlyLiving: List<CellPosition>): Boolean {
        val currentlyLivingNeighbourCount = neighbouringCells().count { it in currentlyLiving }

        if (this !in currentlyLiving) {
            return currentlyLivingNeighbourCount == 3
        }

        return when (currentlyLivingNeighbourCount) {
            in 0..1 -> false
            in 4..8 -> false
            else -> true
        }
    }

    internal fun neighbouringCells(): List<CellPosition> {
        return (-1..1)
            .flatMap { ny ->
                (-1..1)
                    .filterNot { nx -> nx == 0 && ny == 0 }
                    .map { nx -> CellPosition(nx + this.x, ny + this.y) }
            }
    }
}

fun unionCellPositionsFor(cellPositions: List<CellPosition>) =
    cellPositions
        .flatMap { it.neighbouringCells() }
        .distinct()