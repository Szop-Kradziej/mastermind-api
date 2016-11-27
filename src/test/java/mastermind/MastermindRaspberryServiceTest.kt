package mastermind

import org.assertj.core.api.Assertions
import org.junit.Test

class MastermindRaspberryServiceTest {

    @Test
    fun shouldCreateMastermindRaspberryService() {
        Assertions.assertThat(MastermindRaspberryService()).isNotNull()
    }
}

class MastermindRaspberryService {

}
