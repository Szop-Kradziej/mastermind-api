package mastermind

class RandomGameGenerator(val random: () -> Int) : () -> Mastermind {
    override fun invoke(): Mastermind {
        return Mastermind(ColorSet(random() % 8, random() % 8, random() % 8, random() % 8))
    }
}