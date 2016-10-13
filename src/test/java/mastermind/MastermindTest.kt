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
        Assert.assertEquals(0, Mastermind(0, 0, 0, 0).findMatch(1, 1, 1, 1).positionMatch)
        Assert.assertEquals(0, Mastermind(1, 1, 1, 1).findMatch(0, 0, 0, 0).positionMatch)
    }

    @Test
    fun shouldReturnOneMatchForOneCorrectPositionGuess() {
        Assert.assertEquals(1, Mastermind(0, 0, 0, 0).findMatch(0, 1, 1, 1).positionMatch)
        Assert.assertEquals(1, Mastermind(0, 0, 0, 0).findMatch(1, 0, 1, 1).positionMatch)
        Assert.assertEquals(1, Mastermind(0, 0, 0, 0).findMatch(1, 1, 0, 1).positionMatch)
        Assert.assertEquals(1, Mastermind(0, 0, 0, 0).findMatch(1, 1, 1, 0).positionMatch)
        Assert.assertEquals(1, Mastermind(0, 1, 1, 1).findMatch(0, 0, 0, 0).positionMatch)
        Assert.assertEquals(1, Mastermind(1, 0, 1, 1).findMatch(0, 0, 0, 0).positionMatch)
        Assert.assertEquals(1, Mastermind(1, 1, 0, 1).findMatch(0, 0, 0, 0).positionMatch)
        Assert.assertEquals(1, Mastermind(1, 1, 1, 0).findMatch(0, 0, 0, 0).positionMatch)
    }

    @Test
    fun shouldReturnPerfectMatchCorrectly() {
        Assert.assertEquals(4, Mastermind(1, 2, 3, 4).findMatch(1, 2, 3, 4).positionMatch)
    }

    @Test
    fun shouldReturnColorMatchCorrectly() {
        Assert.assertEquals(1, Mastermind(0, 0, 1, 0).findMatch(1, 2, 2, 2).colorMatch)
        Assert.assertEquals(1, Mastermind(0, 0, 1, 1).findMatch(2, 1, 2, 1).colorMatch)
        Assert.assertEquals(1, Mastermind(1, 1, 0, 1).findMatch(2, 2, 2, 0).colorMatch)
        Assert.assertEquals(1, Mastermind(0, 0, 0, 1).findMatch(2, 1, 1, 2).colorMatch)
    }

    @Test
    fun shouldReturnConcreteStructureAsMatchResult() {
        Assert.assertEquals(MatchResult(2, 2), Mastermind(0, 0, 1, 1).findMatch(0, 1, 0, 1))
    }
}

