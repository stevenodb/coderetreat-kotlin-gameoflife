package be.swsb.coderetreat

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class UniverseTest {

//    @Test
//    fun `a universe with a block stays the same`() {
//        val universe = Universe(listOf(0 to 1, 0 to 2, -1 to 1, -1 to 2))
//        val newUniverse = universe.tick()
//        Assertions.assertThat(newUniverse.livingCells).isEqualTo(listOf(0 to 1, 0 to 2, -1 to 1, -1 to 2))
//    }
//
//    @Test
//    fun `a universe with a horizontal blinker after one tick is a vertical`() {
//        val universe = Universe(listOf(-1 to 0, 0 to 0, 1 to 0))
//        val newUniverse = universe.tick()
//        Assertions.assertThat(newUniverse.livingCells).isEqualTo(listOf(0 to -1, 0 to 0, 0 to 1))
//    }

    @Test
    fun `a single living cell with no live neighbours dies`() {
        val universe = Universe(listOf(Cell(0, 0)))
        val newUniverse = universe.tick()
        assertThat(newUniverse.livingCells).hasSize(0)
    }

    @Test
    fun `two neighbouring living cells die`() {
        val universe = Universe(listOf(Cell(0, 0), Cell(0, 1)))
        val newUniverse = universe.tick()
        assertThat(newUniverse.livingCells).hasSize(0)
    }

    @Test
    fun `a living cell in between two living cells survives`() {
        val universe = Universe(listOf(Cell(-1, 0), Cell(0, 0), Cell(1, 0)))
        val newUniverse = universe.tick()
        assertThat(newUniverse.livingCells).contains(Cell(0, 0))
    }

    @Test
    fun `a living cell in between three living cells survives`() {
        val universe = Universe(listOf(Cell(0, 1), Cell(1, 0), Cell(0, 0), Cell(1, 1)))
        val newUniverse = universe.tick()
        assertThat(newUniverse.livingCells).contains(Cell(0, 0))
    }

    @Test
    fun `a living cell in between four living cells dies`() {
        val universe = Universe(listOf(Cell(0, 1), Cell(1, 0), Cell(0, 0), Cell(1, 1), Cell(0, -1)))
        val newUniverse = universe.tick()
        assertThat(newUniverse.livingCells).doesNotContain(Cell(0, 0))
    }

    @Test
    fun `a dead cell with exactly three living neighbours comes alive`() {
        val universe = Universe(listOf(Cell(0, 1), Cell(1, 0), Cell(1, 1)))
        val newUniverse = universe.tick()
        assertThat(newUniverse.livingCells).contains(Cell(0, 0))

    }
}