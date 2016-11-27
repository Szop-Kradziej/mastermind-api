package mastermind

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.never
import com.nhaarman.mockito_kotlin.verify
import com.pi4j.io.gpio.GpioPinDigitalOutput
import io.reactivex.Scheduler
import io.reactivex.schedulers.TestScheduler
import org.junit.Test
import java.util.concurrent.TimeUnit

class MastermindRaspberryServiceTest {

    val output = mock<GpioPinDigitalOutput>()
    val scheduler = TestScheduler()
    val service = MastermindRaspberryService(output, scheduler)

    @Test
    fun shouldBlinkOnGpioController() {
        service.blink()
        verify(output).high()
        scheduler.advanceTimeBy(1, TimeUnit.SECONDS)
        verify(output).low()
    }

    @Test
    fun shouldTurnOnGpioController() {
        service.blink()
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
