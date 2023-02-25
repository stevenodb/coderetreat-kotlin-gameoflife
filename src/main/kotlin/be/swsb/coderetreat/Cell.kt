package be.swsb.coderetreat

data class Cell(val isAlive: Boolean) {
    fun tick(livingNeighbours: Int): Cell {
        return this
    }
}