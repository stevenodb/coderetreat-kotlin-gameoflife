package be.swsb.coderetreat

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CellTest {
    @Test
    fun `Cell can be alive`() {
        val cell = Cell(true)
        assertThat(cell.isAlive).isTrue
    }

    @Test
    fun `Living cell with 3 nb stays avlive`() {
        val cell = Cell(true).tick(3)
        assertThat(cell.isAlive).isTrue()
    }
}