package be.swsb.coderetreat

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

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

    @Test
    fun `Living cell with more than 3 nb dies`() {
        val cell = Cell(true).tick(4)
        assertThat(cell.isAlive).isFalse
    }
}