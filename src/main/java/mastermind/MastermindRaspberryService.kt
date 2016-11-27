package mastermind

import com.pi4j.io.gpio.GpioPinDigitalOutput
import io.reactivex.Scheduler
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger

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