package mastermind

import org.junit.Assert
import org.junit.Test

class MastermindTest {

    @Test
    fun shouldReturnZeroMatchesForTheWorstPossibleGuessCorrectly() {
        Assert.assertEquals(0, findMatchResult(0, 0, 0, 0, 1, 1, 1, 1).positionMatch)
        Assert.assertEquals(0, findMatchResult(1, 1, 1, 1, 0, 0, 0, 0).positionMatch)
    }

    @Test
    fun shouldReturnOneMatchForOneCorrectPositionGuess() {
        Assert.assertEquals(1, findMatchResult(0, 0, 0, 0, 0, 1, 1, 1).positionMatch)
        Assert.assertEquals(1, findMatchResult(0, 0, 0, 0, 1, 0, 1, 1).positionMatch)
        Assert.assertEquals(1, findMatchResult(0, 0, 0, 0, 1, 1, 0, 1).positionMatch)
        Assert.assertEquals(1, findMatchResult(0, 0, 0, 0, 1, 1, 1, 0).positionMatch)
        Assert.assertEquals(1, findMatchResult(0, 1, 1, 1, 0, 0, 0, 0).positionMatch)
        Assert.assertEquals(1, findMatchResult(1, 0, 1, 1, 0, 0, 0, 0).positionMatch)
        Assert.assertEquals(1, findMatchResult(1, 1, 0, 1, 0, 0, 0, 0).positionMatch)
        Assert.assertEquals(1, findMatchResult(1, 1, 1, 0, 0, 0, 0, 0).positionMatch)
    }

    @Test
    fun shouldReturnPerfectMatchCorrectly() {
        Assert.assertEquals(4, findMatchResult(1, 2, 3, 4, 1, 2, 3, 4).positionMatch)
    }

    @Test
    fun shouldReturnColorMatchCorrectly() {
        Assert.assertEquals(1, findMatchResult(0, 0, 1, 0, 1, 2, 2, 2).colorMatch)
        Assert.assertEquals(1, findMatchResult(0, 0, 1, 1, 2, 1, 2, 1).colorMatch)
        Assert.assertEquals(1, findMatchResult(1, 1, 0, 1, 2, 2, 2, 0).colorMatch)
        Assert.assertEquals(1, findMatchResult(0, 0, 0, 1, 2, 1, 1, 2).colorMatch)
    }

    @Test
    fun shouldReturnConcreteStructureAsMatchResult() {
        Assert.assertEquals(MatchResult(2, 2), findMatchResult(0, 0, 1, 1, 0, 1, 0, 1))
    }

    private fun findMatchResult(firstColor: Int,
                                secondColor: Int, 
                                thirdColor: Int,
                                fourthColor: Int,
                                firstColorGuess: Int,
                                secondColorGuess: Int,
                                thirdColorGuess: Int,
                                fourthColorGuess: Int): MatchResult {
        return Mastermind(ColorSet(firstColor, secondColor, thirdColor, fourthColor))
                .findMatch(firstColorGuess, secondColorGuess, thirdColorGuess, fourthColorGuess)
    }
}

