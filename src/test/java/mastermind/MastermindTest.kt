package mastermind

import org.junit.Assert
import org.junit.Test

class MastermindTest {
    @Test
    fun shouldCreateMastermind() {
        Assert.assertNotNull(Mastermind(0, 0, 0, 0))
    }

    @Test
    fun shouldReturnZeroMatchesForTheWorstPossibleGuessCorrectly() {
        Assert.assertEquals(0, Mastermind(0, 0, 0, 0).findPositionMatch(1, 1, 1, 1))
        Assert.assertEquals(0, Mastermind(1, 1, 1, 1).findPositionMatch(0, 0, 0, 0))
    }

    @Test
    fun shouldReturnOneMatchForOneCorrectPositionGuess() {
        Assert.assertEquals(1, Mastermind(0, 0, 0, 0).findPositionMatch(0, 1, 1, 1))
        Assert.assertEquals(1, Mastermind(0, 0, 0, 0).findPositionMatch(1, 0, 1, 1))
        Assert.assertEquals(1, Mastermind(0, 0, 0, 0).findPositionMatch(1, 1, 0, 1))
        Assert.assertEquals(1, Mastermind(0, 0, 0, 0).findPositionMatch(1, 1, 1, 0))
        Assert.assertEquals(1, Mastermind(0, 1, 1, 1).findPositionMatch(0, 0, 0, 0))
        Assert.assertEquals(1, Mastermind(1, 0, 1, 1).findPositionMatch(0, 0, 0, 0))
        Assert.assertEquals(1, Mastermind(1, 1, 0, 1).findPositionMatch(0, 0, 0, 0))
        Assert.assertEquals(1, Mastermind(1, 1, 1, 0).findPositionMatch(0, 0, 0, 0))
    }

    @Test
    fun shouldReturnPerfectMatchCorrectly() {
        Assert.assertEquals(4, Mastermind(1, 2, 3, 4).findPositionMatch(1, 2, 3, 4))
    }

    @Test
    fun shouldReturnColorMatchCorrectly() {
        Assert.assertEquals(1, Mastermind(0, 0, 1, 0).findColorMatch(1, 2, 2, 2))
        Assert.assertEquals(2, Mastermind(0, 0, 1, 1).findColorMatch(2, 1, 2, 1))
    }
}