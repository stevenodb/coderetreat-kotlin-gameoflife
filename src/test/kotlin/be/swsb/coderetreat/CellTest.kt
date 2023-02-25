package be.swsb.coderetreat

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CellTest {
    @Test
    fun `Cell can be alive`() {
        val cell = Cell(true)
        assertThat(cell.isAlive).isTrue
    }

    @Test
    fun `Living cell with 3 nb stays alive`() {
        val cell = Cell(true).tick(3)
        assertThat(cell.isAlive).isTrue
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8])
    fun `Living cell with more than 3 nb dies`(amountOfLivingNeighbours: Int) {
        val cell = Cell(true).tick(amountOfLivingNeighbours)
        assertThat(cell.isAlive).isFalse
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1])
    fun `Living cell with less than 2 nb dies`(amountOfLivingNeighbours: Int) {
        val cell = Cell(true).tick(amountOfLivingNeighbours)
        assertThat(cell.isAlive).isFalse
    }
}