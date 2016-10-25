package mastermind

import org.junit.Assert
import org.junit.Test
import java.util.*

class MastermindServiceTest {

    @Test
    fun shouldMovesContainsFirstGuess() {
        val mastermind = Mastermind(ColorSet(0, 1, 1, 1))
        val guess = listOf(0, 0, 0, 0)
        Assert.assertEquals(guess, MastermindService({ mastermind }).makeMove(guess).moves.first().guess)
    }

    @Test
    fun shouldMovesContainsMatchResultForFirstGuess() {
        val mastermind = Mastermind(ColorSet(0, 1, 1, 1))
        val guess = listOf(0, 0, 0, 0)
        val matchResult = MatchResult(1, 0)
        Assert.assertEquals(matchResult, MastermindService({ mastermind }).makeMove(guess).moves.first().match)
    }

    @Test
    fun shouldMatchBeCalculatedProperly() {
        val mastermind = Mastermind(ColorSet(0, 0, 1, 1))
        val guess = listOf(0, 0, 0, 0)
        val match = MatchResult(2, 0)
        Assert.assertEquals(match, MastermindService({ mastermind }).makeMove(guess).moves.first().match)
    }

    @Test
    fun shouldMovesContainsBothMoves() {
        val mastermind = Mastermind(ColorSet(0, 0, 0, 1))
        val guess = listOf(0, 0, 0, 0)
        val service = MastermindService({ mastermind })
        service.makeMove(guess)
        Assert.assertEquals(2, service.makeMove(guess).moves.size)
    }
}

class MastermindService(val randomGameGenerator: () -> Mastermind) {
    val moves = ArrayList<Move>()

    fun makeMove(guess: List<Int>): GameStatus {
        val match = randomGameGenerator().findMatch(ColorSet.from(guess))
        moves.add(Move(guess, match))
        return GameStatus(moves)
    }
}

