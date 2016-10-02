package mastermind

class Mastermind(val firstColor: Int,
                 val secondColor: Int,
                 val thirdColor: Int,
                 val fourthColor: Int) {

    fun findMatch(firstColorGuess: Int,
                  secondColorGuess: Int,
                  thirdColorGuess: Int,
                  fourthColorGuess: Int): Int {
        return listOf(1 - firstColorGuess, 1 - secondColorGuess, 1 - thirdColorGuess, 1 - fourthColorGuess).max()!!
    }
}
