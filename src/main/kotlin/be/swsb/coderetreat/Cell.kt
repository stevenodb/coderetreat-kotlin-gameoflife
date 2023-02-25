package be.swsb.coderetreat

data class Cell(val isAlive: Boolean) {
    fun tick(livingNeighbours: Int): Cell {
        return if (livingNeighbours > 3) Cell(false) else Cell(true)
    }
}