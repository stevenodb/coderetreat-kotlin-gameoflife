package be.swsb.coderetreat

class Universe(livingPairs: List<Pair<Int, Int>>) {
    val livingCells: MutableMap<Pair<Int, Int>, Cell> = mutableMapOf()

    init {
        livingPairs.forEach { pair -> livingCells[pair] = Cell(true) }
    }

}