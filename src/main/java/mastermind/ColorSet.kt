package mastermind

data class ColorSet(val first: Int,
                    val second: Int,
                    val third: Int,
                    val fourth: Int) {

    fun toList(): List<Int> {
        return listOf(first, second, third, fourth)
    }

    companion object{
        fun from(colors: List<Int>): ColorSet {
            return ColorSet(colors[0], colors[1], colors[2], colors[3])
        }
    }
}
