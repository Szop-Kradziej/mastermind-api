package mastermind

import java.util.*

class MastermindService(val randomGameGenerator: () -> Mastermind) {
    val games = HashMap<String, GameStatus>()

    fun makeMove(id: String, guess: List<Int>): GameStatus {
        val match = randomGameGenerator().findMatch(ColorSet.from(guess))
        addMoveToProperGame(id, Move(guess, match));
        return games.get(id)!!
    }

    private fun addMoveToProperGame(id: String, move: Move) {
        if (games.containsKey(id)) {
            val game = games.get(id)
            val moves = game!!.moves.toMutableList()
            moves.add(move)
            games.put(id, GameStatus(moves))
        } else {
            games.put(id, GameStatus(listOf(move)))
        }
    }
}