package mastermind

class RandomGameGenerator(val random: () -> Int) : () -> Mastermind {
    override fun invoke(): Mastermind {
        return Mastermind(ColorSet(getRandomColor(), getRandomColor(), getRandomColor(), getRandomColor()))
    }

    private fun getRandomColor() = ((random() % 8) + 8) % 8
}