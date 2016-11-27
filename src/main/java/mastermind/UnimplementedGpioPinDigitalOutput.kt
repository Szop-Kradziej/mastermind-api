package mastermind

import com.pi4j.io.gpio.*
import com.pi4j.io.gpio.event.GpioPinListener
import java.util.concurrent.Callable
import java.util.concurrent.Future

open class UnimplementedGpioPinDigitalOutput : GpioPinDigitalOutput {
    override fun getPin(): Pin {
        throw UnsupportedOperationException("not implemented")
    }

    override fun getName(): String {
        throw UnsupportedOperationException("not implemented")
    }

    override fun getListeners(): MutableCollection<GpioPinListener> {
        throw UnsupportedOperationException("not implemented")
    }

    override fun addListener(vararg listener: GpioPinListener?) {
        throw UnsupportedOperationException("not implemented")
    }

    override fun addListener(listeners: MutableList<out GpioPinListener>?) {
        throw UnsupportedOperationException("not implemented")
    }

    override fun hasListener(vararg listener: GpioPinListener?): Boolean {
        throw UnsupportedOperationException("not implemented")
    }

    override fun getProperties(): MutableMap<String, String> {
        throw UnsupportedOperationException("not implemented")
    }

    override fun getProperty(key: String?): String {
        throw UnsupportedOperationException("not implemented")
    }

    override fun getProperty(key: String?, defaultValue: String?): String {
        throw UnsupportedOperationException("not implemented")
    }

    override fun isPullResistance(resistance: PinPullResistance?): Boolean {
        throw UnsupportedOperationException("not implemented")
    }

    override fun removeListener(vararg listener: GpioPinListener?) {
        throw UnsupportedOperationException("not implemented")
    }

    override fun removeListener(listeners: MutableList<out GpioPinListener>?) {
        throw UnsupportedOperationException("not implemented")
    }

    override fun unexport() {
        throw UnsupportedOperationException("not implemented")
    }

    override fun getMode(): PinMode {
        throw UnsupportedOperationException("not implemented")
    }

    override fun getTag(): Any {
        throw UnsupportedOperationException("not implemented")
    }

    override fun getPullResistance(): PinPullResistance {
        throw UnsupportedOperationException("not implemented")
    }

    override fun hasProperty(key: String?): Boolean {
        throw UnsupportedOperationException("not implemented")
    }

    override fun setShutdownOptions(options: GpioPinShutdown?) {
        throw UnsupportedOperationException("not implemented")
    }

    override fun setShutdownOptions(unexport: Boolean?) {
        throw UnsupportedOperationException("not implemented")
    }

    override fun setShutdownOptions(unexport: Boolean?, state: PinState?) {
        throw UnsupportedOperationException("not implemented")
    }

    override fun setShutdownOptions(unexport: Boolean?, state: PinState?, resistance: PinPullResistance?) {
        throw UnsupportedOperationException("not implemented")
    }

    override fun setShutdownOptions(unexport: Boolean?, state: PinState?, resistance: PinPullResistance?, mode: PinMode?) {
        throw UnsupportedOperationException("not implemented")
    }

    override fun setMode(mode: PinMode?) {
        throw UnsupportedOperationException("not implemented")
    }

    override fun setProperty(key: String?, value: String?) {
        throw UnsupportedOperationException("not implemented")
    }

    override fun clearProperties() {
        throw UnsupportedOperationException("not implemented")
    }

    override fun isExported(): Boolean {
        throw UnsupportedOperationException("not implemented")
    }

    override fun setPullResistance(resistance: PinPullResistance?) {
        throw UnsupportedOperationException("not implemented")
    }

    override fun removeProperty(key: String?) {
        throw UnsupportedOperationException("not implemented")
    }

    override fun isMode(mode: PinMode?): Boolean {
        throw UnsupportedOperationException("not implemented")
    }

    override fun getShutdownOptions(): GpioPinShutdown {
        throw UnsupportedOperationException("not implemented")
    }

    override fun getProvider(): GpioProvider {
        throw UnsupportedOperationException("not implemented")
    }

    override fun setName(name: String?) {
        throw UnsupportedOperationException("not implemented")
    }

    override fun export(mode: PinMode?) {
        throw UnsupportedOperationException("not implemented")
    }

    override fun export(mode: PinMode?, defaultState: PinState?) {
        throw UnsupportedOperationException("not implemented")
    }

    override fun setTag(tag: Any?) {
        throw UnsupportedOperationException("not implemented")
    }

    override fun removeAllListeners() {
        throw UnsupportedOperationException("not implemented")
    }

    override fun pulse(duration: Long): Future<*> {
        throw UnsupportedOperationException("not implemented")
    }

    override fun pulse(duration: Long, callback: Callable<Void>?): Future<*> {
        throw UnsupportedOperationException("not implemented")
    }

    override fun pulse(duration: Long, blocking: Boolean): Future<*> {
        throw UnsupportedOperationException("not implemented")
    }

    override fun pulse(duration: Long, blocking: Boolean, callback: Callable<Void>?): Future<*> {
        throw UnsupportedOperationException("not implemented")
    }

    override fun pulse(duration: Long, pulseState: PinState?): Future<*> {
        throw UnsupportedOperationException("not implemented")
    }

    override fun pulse(duration: Long, pulseState: PinState?, callback: Callable<Void>?): Future<*> {
        throw UnsupportedOperationException("not implemented")
    }

    override fun pulse(duration: Long, pulseState: PinState?, blocking: Boolean): Future<*> {
        throw UnsupportedOperationException("not implemented")
    }

    override fun pulse(duration: Long, pulseState: PinState?, blocking: Boolean, callback: Callable<Void>?): Future<*> {
        throw UnsupportedOperationException("not implemented")
    }

    override fun setState(state: PinState?) {
        throw UnsupportedOperationException("not implemented")
    }

    override fun setState(state: Boolean) {
        throw UnsupportedOperationException("not implemented")
    }

    override fun low() {
        throw UnsupportedOperationException("not implemented")
    }

    override fun high() {
        throw UnsupportedOperationException("not implemented")
    }

    override fun toggle() {
        throw UnsupportedOperationException("not implemented")
    }

    override fun blink(delay: Long): Future<*> {
        throw UnsupportedOperationException("not implemented")
    }

    override fun blink(delay: Long, blinkState: PinState?): Future<*> {
        throw UnsupportedOperationException("not implemented")
    }

    override fun blink(delay: Long, duration: Long): Future<*> {
        throw UnsupportedOperationException("not implemented")
    }

    override fun blink(delay: Long, duration: Long, blinkState: PinState?): Future<*> {
        throw UnsupportedOperationException("not implemented")
    }

    override fun isHigh(): Boolean {
        throw UnsupportedOperationException("not implemented")
    }

    override fun isLow(): Boolean {
        throw UnsupportedOperationException("not implemented")
    }

    override fun getState(): PinState {
        throw UnsupportedOperationException("not implemented")
    }

    override fun isState(state: PinState?): Boolean {
        throw UnsupportedOperationException("not implemented")
    }
}