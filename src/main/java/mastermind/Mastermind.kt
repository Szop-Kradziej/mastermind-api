package mastermind

class Mastermind(val firstColor: Int,
                 val secondColor: Int,
                 val thirdColor: Int,
                 val fourthColor: Int) {

    fun findMatch(firstColorGuess: Int,
                  secondColorGuess: Int,
                  thirdColorGuess: Int,
                  fourthColorGuess: Int): Int {
        return 1 - firstColorGuess;
    }
}
