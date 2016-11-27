package mastermind

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.never
import com.nhaarman.mockito_kotlin.verify
import com.pi4j.io.gpio.GpioPinDigitalOutput
import io.reactivex.Scheduler
import io.reactivex.schedulers.TestScheduler
import org.junit.Test
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger

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

    @Test
    fun shouldQueueBlinks() {
        service.blink()
        service.blink()
        verify(output).high()
    }
}

class MastermindRaspberryService(
        private val output: GpioPinDigitalOutput,
        private val scheduler: Scheduler) {

    val queue = AtomicInteger(0)

    fun blink() {
        if (queue.getAndIncrement() == 0) {
            start()
        }
    }

    private fun start() {
        output.high()
        wait {
            output.low()
            wait {
                checkQueueAndRepeat()
            }
        }
    }

    private fun wait(block: () -> Unit) {
        scheduler.scheduleDirect(block, 1, TimeUnit.SECONDS)
    }

    private fun checkQueueAndRepeat() {
        if (queue.decrementAndGet() > 0) {
            start()
        }
    }
}
