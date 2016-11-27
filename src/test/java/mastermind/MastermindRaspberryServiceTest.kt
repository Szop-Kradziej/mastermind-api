package mastermind

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.pi4j.io.gpio.GpioPinDigitalOutput
import org.assertj.core.api.Assertions
import org.junit.Test

class MastermindRaspberryServiceTest {

    @Test
    fun shouldCreateMastermindRaspberryService() {
        Assertions.assertThat(MastermindRaspberryService(mock<GpioPinDigitalOutput>())).isNotNull()
    }

    @Test
    fun shouldBlinkOnGpioController() {
        val output = mock<GpioPinDigitalOutput>()
        MastermindRaspberryService(output).blink()
        verify(output).high()
        verify(output).low()
    }
}

class MastermindRaspberryService(private val output: GpioPinDigitalOutput) {
    fun blink() {
        output.high()
        output.low()
    }
}
