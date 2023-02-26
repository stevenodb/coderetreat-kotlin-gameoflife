package be.swsb.coderetreat

data class CellPosition(val x: Int, val y: Int) {

    fun neighbouringCells(): List<CellPosition> {
        return (-1..1)
            .flatMap { ny ->
                (-1..1)
                    .filterNot { nx -> nx == 0 && ny == 0 }
                    .map { nx -> CellPosition(nx + x, ny + y) }
            }
    }
}