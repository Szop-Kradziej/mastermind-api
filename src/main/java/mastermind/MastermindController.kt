package mastermind

import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class MastermindController {
    private val random = { Random().nextInt() }
    private val randomGameGenerator = RandomGameGenerator(random)
    private val mastermindService = MastermindService(randomGameGenerator)

    @RequestMapping("/mastermind/{id}")
    fun makeMove(@PathVariable("id") id: String, @RequestParam("guess[]") guess: List<Int>): GameStatus {
        return mastermindService.makeMove(id, guess)
    }
}