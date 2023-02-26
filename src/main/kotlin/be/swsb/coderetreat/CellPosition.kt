package be.swsb.coderetreat

data class CellPosition(val x: Int, val y: Int) {

    fun isAliveNextGiven(currentlyLiving: List<CellPosition>): Boolean {
        val currentlyLivingNeighbourCount = neighbouringCells(onlyConsider = currentlyLiving).count()

        if (this !in currentlyLiving) {
            return currentlyLivingNeighbourCount == 3
        }

        return when (currentlyLivingNeighbourCount) {
            in 0..1 -> false
            in 4..8 -> false
            else -> true
        }
    }

    fun neighbouringCells(onlyConsider: List<CellPosition>? = null): List<CellPosition> {
        return (-1..1)
            .flatMap { ny ->
                (-1..1)
                    .filterNot { nx -> nx == 0 && ny == 0 }
                    .map { nx -> CellPosition(nx + x, ny + y) }
            }.filter { onlyConsider == null || it in onlyConsider }
    }
}