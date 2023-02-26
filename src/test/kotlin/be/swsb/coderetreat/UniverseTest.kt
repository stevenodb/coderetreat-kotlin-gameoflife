package be.swsb.coderetreat

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class UniverseTest {

    @Test
    fun `a universe with a horizontal blinker after one tick is a vertical`() {
        val universe = Universe(CellPosition(-1, 0), CellPosition(0, 0), CellPosition( 1, 0))
        val newUniverse = universe.tick()
        assertThat(newUniverse.livingCellPositions).contains(CellPosition(0, -1), CellPosition(0, 0), CellPosition(0, 1))
    }

    @Test
    fun `a single living cell with no live neighbours dies`() {
        val universe = Universe(CellPosition(0, 0))
        val newUniverse = universe.tick()
        assertThat(newUniverse.livingCellPositions).hasSize(0)
    }

    @Test
    fun `two neighbouring living cells die`() {
        val universe = Universe(CellPosition(0, 0), CellPosition(0, 1))
        val newUniverse = universe.tick()
        assertThat(newUniverse.livingCellPositions).hasSize(0)
    }

    @Test
    fun `a living cell in between two living cells survives`() {
        val universe = Universe(CellPosition(-1, 0), CellPosition(0, 0), CellPosition(1, 0))
        val newUniverse = universe.tick()
        assertThat(newUniverse.livingCellPositions).contains(CellPosition(0, 0))
    }

    @Test
    fun `a living cell in between three living cells survives`() {
        val universe = Universe(CellPosition(0, 1), CellPosition(1, 0), CellPosition(0, 0), CellPosition(1, 1))
        val newUniverse = universe.tick()
        assertThat(newUniverse.livingCellPositions).contains(CellPosition(0, 0))
    }

    @Test
    fun `a living cell in between four living cells dies`() {
        val universe = Universe(CellPosition(0, 1), CellPosition(1, 0), CellPosition(0, 0), CellPosition(1, 1), CellPosition(0, -1))
        val newUniverse = universe.tick()
        assertThat(newUniverse.livingCellPositions).doesNotContain(CellPosition(0, 0))
    }

    @Test
    fun `a dead cell with exactly three living neighbours comes alive`() {
        val universe = Universe(CellPosition(0, 1), CellPosition(1, 0), CellPosition(1, 1))
        val newUniverse = universe.tick()
        assertThat(newUniverse.livingCellPositions).contains(CellPosition(0, 0))
    }
}