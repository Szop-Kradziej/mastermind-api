package mastermind

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Assert
import org.junit.Ignore
import org.junit.Test

class RandomGameGeneratorTest {

    @Test
    fun shouldGenerateRandomGame() {
        val random = mock<Function0<Int>>()
        whenever(random.invoke()).thenReturn(0)
        Assert.assertEquals(Mastermind(ColorSet(0, 0, 0, 0)), RandomGameGenerator(random).invoke())
    }

    @Test
    fun shouldGenerateRandomGameWithFixMaxColorValue() {
        val random = mock<Function0<Int>>()
        whenever(random.invoke()).thenReturn(6).thenReturn(7).thenReturn(8).thenReturn(9)
        Assert.assertEquals(Mastermind(ColorSet(6, 7, 0, 1)), RandomGameGenerator(random).invoke())
    }
}

class RandomGameGenerator(val random: () -> Int) : () -> Mastermind {
    override fun invoke(): Mastermind {
        return Mastermind(ColorSet(random(), random(), random() % 8, random() % 8))
    }
}
