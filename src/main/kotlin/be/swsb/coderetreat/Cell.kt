package be.swsb.coderetreat

data class Cell(val isAlive: Boolean) {
    fun tick(livingNeighbours: Int): Cell {

        if (!isAlive) {
            return if (livingNeighbours == 3) Cell(true) else Cell(false)
        }

        return when (livingNeighbours) {
            in 0..1 -> Cell(false)
            in 4..8 -> Cell(false)
            else -> {
                Cell(true)
            }
        }
    }
}