package be.swsb.coderetreat

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class UniverseTest {
    @Test
    fun name() {
        val universe = Universe(listOf(1 to 1))
        Assertions.assertThat(universe.livingCells).hasSize(1)
    }
}