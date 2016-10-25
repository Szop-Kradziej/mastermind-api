package mastermind

import org.junit.Assert
import org.junit.Test

class MastermindServiceTest {

    @Test
    fun shouldMakeMoveMethodExists() {
        Assert.assertNotNull(MastermindService().makeMove())
    }
}

class MastermindService {
    fun  makeMove(): MatchResult {
        return MatchResult(1,1)
    }

}
