package mastermind

import org.junit.Assert
import org.junit.Test

class MastermindServiceTest {

    @Test
    fun shouldMovesContainsFirstGuess() {
        val guess = listOf(0, 0, 0, 0)
        Assert.assertEquals(guess, MastermindService().makeMove(guess).moves.first().guess)
    }

    @Test
    fun shouldMovesContainsMatchResultForFirstGuess() {
        val guess = listOf(0,0,0,0)
        val matchResult = MatchResult(1,0)
        Assert.assertEquals(matchResult, MastermindService().makeMove(guess).moves.first().match)
    }
}

class MastermindService {
    fun makeMove(guess: List<Int>): GameStatus {
        return GameStatus(listOf(Move(guess, MatchResult(1,0))))
    }

}

