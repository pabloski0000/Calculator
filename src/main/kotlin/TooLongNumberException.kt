import java.lang.RuntimeException

class TooLongNumberException(
    val maximumSizeOfNumber: Int = 2147483647,
    override val message: String = "A number has exceeded the maximum size, which is: $maximumSizeOfNumber"
): RuntimeException() {
}