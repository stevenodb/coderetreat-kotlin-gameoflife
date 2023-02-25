package be.swsb.coderetreat

data class Cell(val isAlive: Boolean) {
    fun tick(livingNeighbours: Int): Cell {
        return when (livingNeighbours) {
            in 0..1 -> Cell(false)
            in 4..8 -> Cell(false)
            else -> {
                Cell(true)
            }
        }
    }
}