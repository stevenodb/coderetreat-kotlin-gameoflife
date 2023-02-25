package be.swsb.coderetreat

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class CellTest {
    @Test
    fun `Cell can be alive`() {
        val cell = Cell(true)
        Assertions.assertThat(cell.isAlive).isTrue
    }
}