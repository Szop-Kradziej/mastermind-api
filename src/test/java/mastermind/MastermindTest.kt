package mastermind

import org.junit.Assert
import org.junit.Test

class MastermindTest {
    @Test
    fun shouldCreateMastermind() {
        Assert.assertNotNull(Mastermind(0,0,0,0))
    }
}