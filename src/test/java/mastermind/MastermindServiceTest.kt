package mastermind

import org.junit.Assert
import org.junit.Test
import java.util.*

class MastermindServiceTest {

    @Test
    fun shouldMovesContainsFirstGuess() {
        val mastermind = Mastermind(ColorSet(0, 1, 1, 1))
        val guess = listOf(0, 0, 0, 0)
        Assert.assertEquals(guess, MastermindService({ mastermind }).makeMove("id", guess).moves.first().guess)
    }

    @Test
    fun shouldMovesContainsMatchResultForFirstGuess() {
        val mastermind = Mastermind(ColorSet(0, 1, 1, 1))
        val guess = listOf(0, 0, 0, 0)
        val matchResult = MatchResult(1, 0)
        Assert.assertEquals(matchResult, MastermindService({ mastermind }).makeMove("id", guess).moves.first().match)
    }

    @Test
    fun shouldMatchBeCalculatedProperly() {
        val mastermind = Mastermind(ColorSet(0, 0, 1, 1))
        val guess = listOf(0, 0, 0, 0)
        val match = MatchResult(2, 0)
        Assert.assertEquals(match, MastermindService({ mastermind }).makeMove("id", guess).moves.first().match)
    }

    @Test
    fun shouldMovesContainsBothMoves() {
        val mastermind = Mastermind(ColorSet(0, 0, 0, 1))
        val guess = listOf(0, 0, 0, 0)
        val service = MastermindService({ mastermind })
        service.makeMove("id", guess)
        Assert.assertEquals(2, service.makeMove("id", guess).moves.size)
    }

    @Test
    fun shouldMovesContainsMovesOnlyForSpecifyGame() {
        val mastermind = Mastermind(ColorSet(0, 0, 0, 1))
        val guess = listOf(0, 0, 0, 0)
        val service = MastermindService({ mastermind })
        service.makeMove("id", guess)
        Assert.assertEquals(1, service.makeMove("id2", guess).moves.size)
    }
}

class MastermindService(val randomGameGenerator: () -> Mastermind) {
    val games = HashMap<String, GameStatus>()

    fun makeMove(id: String, guess: List<Int>): GameStatus {
        val match = randomGameGenerator().findMatch(ColorSet.from(guess))
        addMoveToProperGame(id, Move(guess, match));
        return games.get(id)!!
    }

    private fun  addMoveToProperGame(id: String, move: Move) {
        if(games.containsKey(id)) {
            val game = games.get(id)
            val moves = game!!.moves.toMutableList()
            moves.add(move)
            games.put(id, GameStatus(moves))
        } else {
            games.put(id, GameStatus(listOf(move)))
        }
    }
}

