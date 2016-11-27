package mastermind

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.never
import com.nhaarman.mockito_kotlin.verify
import com.pi4j.io.gpio.GpioPinDigitalOutput
import io.reactivex.Scheduler
import io.reactivex.schedulers.TestScheduler
import org.assertj.core.api.Assertions
import org.junit.Test
import java.util.concurrent.TimeUnit

class MastermindRaspberryServiceTest {

    @Test
    fun shouldCreateMastermindRaspberryService() {
        Assertions.assertThat(MastermindRaspberryService(mock(), TestScheduler())).isNotNull()
    }

    @Test
    fun shouldBlinkOnGpioController() {
        val output = mock<GpioPinDigitalOutput>()
        val scheduler = TestScheduler()
        MastermindRaspberryService(output, scheduler).blink()
        verify(output).high()
        scheduler.advanceTimeBy(1, TimeUnit.SECONDS)
        verify(output).low()
    }

    @Test
    fun shouldTurnOnGpioController() {
        val output = mock<GpioPinDigitalOutput>()
        val scheduler = TestScheduler()
        MastermindRaspberryService(output, scheduler).blink()
        verify(output).high()
        verify(output, never()).low()
    }
}

class MastermindRaspberryService(private val output: GpioPinDigitalOutput, private val scheduler: Scheduler) {
    fun blink() {
        output.high()
        scheduler.scheduleDirect({
            output.low()
        },1, TimeUnit.SECONDS)
    }
}
