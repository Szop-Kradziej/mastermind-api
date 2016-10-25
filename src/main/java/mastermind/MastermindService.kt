package mastermind

import java.util.*

class MastermindService(val randomGameGenerator: () -> Mastermind) {
    val gamesStatuses = HashMap<String, GameStatus>()
    val games = HashMap<String, Mastermind>()

    fun makeMove(id: String, guess: List<Int>): GameStatus {
        addMoveToProperGame(id, guess);
        return gamesStatuses.get(id)!!
    }

    private fun addMoveToProperGame(id: String, guess: List<Int>) {
        if (gamesStatuses.containsKey(id)) {
            val game = gamesStatuses.get(id)
            val moves = game!!.moves.toMutableList()
            val move = createMove(id, guess)
            moves.add(move)
            gamesStatuses.put(id, GameStatus(moves))
        } else {
            val move = createMove(id, guess)
            gamesStatuses.put(id, GameStatus(listOf(move)))
        }
    }

    private fun createMove(id: String, guess: List<Int>): Move {
        val match = games.getOrPut(id, randomGameGenerator).findMatch(ColorSet.from(guess))
        return Move(guess, match)
    }
}