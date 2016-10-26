package mastermind

data class Mastermind(val code: ColorSet) {

    fun findMatch(guess: ColorSet): MatchResult {
        val positionMatch = findPositionMatch(guess)
        val colorMatch = findColorMatch(guess)
        return MatchResult(positionMatch, colorMatch - positionMatch)
    }

    private fun findPositionMatch(guess: ColorSet): Int {
        return listOf(code.first == guess.first,
                code.second ==  guess.second,
                code.third == guess.third,
                code.fourth == guess.fourth).count { it == true }
    }

    private fun findColorMatch(guess: ColorSet): Int {
        val colors = code.toList().toMutableList()
        return guess.toList().count { colors.remove(it) }
    }
}
