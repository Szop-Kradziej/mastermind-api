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
            val match = games.get(id)!!.findMatch(ColorSet.from(guess))
            moves.add(Move(guess, match))
            gamesStatuses.put(id, GameStatus(moves))
        } else {
            games.put(id, randomGameGenerator())
            val match = games.get(id)!!.findMatch(ColorSet.from(guess))
            gamesStatuses.put(id, GameStatus(listOf(Move(guess, match))))
        }
    }
}