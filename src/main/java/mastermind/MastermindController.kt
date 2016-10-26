package mastermind

import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class MastermindController {

    @RequestMapping("/mastermind/{id}")
    fun makeMove(@PathVariable("id") id: String, @RequestParam("guess") guess: List<Int>): GameStatus {
       throw RuntimeException()
    }
}