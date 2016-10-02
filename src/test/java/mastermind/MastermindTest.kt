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
        Assert.assertEquals(0, Mastermind(0, 0, 0, 0).findMatch(1, 1, 1, 1))
    }

    @Test
    fun shouldReturnOneMatchForOneCorrectColorGuess() {
        Assert.assertEquals(1, Mastermind(0, 0, 0, 0).findMatch(0, 1, 1, 1))
        Assert.assertEquals(1, Mastermind(0, 0, 0, 0).findMatch(1, 0, 1, 1))
        Assert.assertEquals(1, Mastermind(0, 0, 0, 0).findMatch(1, 1, 0, 1))
        Assert.assertEquals(1, Mastermind(0, 0, 0, 0).findMatch(1, 1, 1, 0))
        Assert.assertEquals(1, Mastermind(0, 1, 1, 1).findMatch(0, 0, 0, 0))
        Assert.assertEquals(1, Mastermind(1, 0, 1, 1).findMatch(0, 0, 0, 0))
        Assert.assertEquals(1, Mastermind(1, 1, 0, 1).findMatch(0, 0, 0, 0))
        Assert.assertEquals(1, Mastermind(1, 1, 1, 0).findMatch(0, 0, 0, 0))
    }
}