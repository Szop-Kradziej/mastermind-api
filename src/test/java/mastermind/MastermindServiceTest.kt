package mastermind

import org.junit.Assert
import org.junit.Test

class MastermindServiceTest {

    @Test
    fun shouldMakeMoveReturnGameStatusMoves() {
        Assert.assertNotNull(MastermindService().makeMove().moves)
    }
}

class MastermindService {
    fun  makeMove(): GameStatus {
        return GameStatus(emptyList())
    }

}

