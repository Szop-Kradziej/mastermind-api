package mastermind

class Mastermind(val colorSet: ColorSet) {

    fun findMatch(firstColorGuess: Int,
                  secondColorGuess: Int,
                  thirdColorGuess: Int,
                  fourthColorGuess: Int): MatchResult {
        val positionMatch = findPositionMatch(firstColorGuess, secondColorGuess, thirdColorGuess, fourthColorGuess)
        val colorMatch = findColorMatch(firstColorGuess,secondColorGuess,thirdColorGuess,fourthColorGuess)
        return MatchResult(positionMatch, colorMatch - positionMatch)
    }

    private fun findPositionMatch(firstColorGuess: Int,
                          secondColorGuess: Int,
                          thirdColorGuess: Int,
                          fourthColorGuess: Int): Int {
        return listOf(colorSet.first == firstColorGuess,
                colorSet.second == secondColorGuess,
                colorSet.third == thirdColorGuess,
                colorSet.fourth == fourthColorGuess).count { it == true }
    }

    private fun findColorMatch(firstColorGuess: Int,
                       secondColorGuess: Int,
                       thirdColorGuess: Int,
                       fourthColorGuess: Int): Int {
        val colors = colorSet.toList().toMutableList()
        return listOf(firstColorGuess,
                secondColorGuess,
                thirdColorGuess,
                fourthColorGuess).count { colors.remove(it) }
    }
}
