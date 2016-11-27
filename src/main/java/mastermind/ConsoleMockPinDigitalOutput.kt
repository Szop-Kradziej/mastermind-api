package mastermind

class ConsoleMockPinDigitalOutput : UnimplementedGpioPinDigitalOutput() {

    override fun low() {
        println("Low")
    }

    override fun high() {
        println("High")
    }
}