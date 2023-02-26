package be.swsb.coderetreat

data class CellPosition(val x: Int, val y: Int) {

    fun isAliveGiven(currentlyLiving: Set<CellPosition>): Boolean {
        return when (neighbouringCells(onlyConsider = currentlyLiving).count()) {
            in 0..1 -> false
            in 2..3 -> true
            in 4..8 -> false
            else -> false
        }
    }

    fun neighbouringCells(onlyConsider: Set<CellPosition>? = null): Set<CellPosition> {
        return (-1..1)
            .flatMap { ny ->
                (-1..1)
                    .filterNot { nx -> nx == 0 && ny == 0 }
                    .map { nx -> CellPosition(nx + x, ny + y) }
            }.filter { onlyConsider == null || it in onlyConsider }.toSet()
    }
}