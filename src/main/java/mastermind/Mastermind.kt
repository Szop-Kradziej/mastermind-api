package mastermind

class Mastermind(val firstColor: Int,
                 val secondColor: Int,
                 val thirdColor: Int,
                 val fourthColor: Int) {

    fun findMatch(firstColorGuess: Int,
                  secondColorGuess: Int,
                  thirdColorGuess: Int,
                  fourthColorGuess: Int): Int {
        return listOf(firstColor == firstColorGuess,
                secondColor == secondColorGuess,
                thirdColor == thirdColorGuess,
                fourthColor == fourthColorGuess).count { it == true }
    }

    fun findSwitchMatch(i: Int, i1: Int, i2: Int, i3: Int): Long {
        return 1;
    }
}
