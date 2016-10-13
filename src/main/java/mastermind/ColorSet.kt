package mastermind

data class ColorSet(val first: Int,
                    val second: Int,
                    val third: Int,
                    val fourth: Int) {

    fun toList(): List<Int> {
        return listOf(first, second, third, fourth)
    }
}