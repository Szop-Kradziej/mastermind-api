package mastermind

class Mastermind(val firstColor: Int,
                 val secondColor: Int,
                 val thirdColor: Int,
                 val fourthColor: Int) {

    fun findPositionMatch(firstColorGuess: Int,
                          secondColorGuess: Int,
                          thirdColorGuess: Int,
                          fourthColorGuess: Int): Int {
        return listOf(firstColor == firstColorGuess,
                secondColor == secondColorGuess,
                thirdColor == thirdColorGuess,
                fourthColor == fourthColorGuess).count { it == true }
    }

    fun findColorMatch(firstColorGuess: Int,
                       secondColorGuess: Int,
                       thirdColorGuess: Int,
                       fourthColorGuess: Int): Int {
        val colors = listOf(firstColor, secondColor, thirdColor, fourthColor).toMutableList()
        return listOf(firstColorGuess,
                secondColorGuess,
                thirdColorGuess,
                fourthColorGuess).count { colors.remove(it) }
    }
}
