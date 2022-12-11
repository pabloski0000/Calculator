package exceptions

import java.lang.RuntimeException

class SpaceBetweenTwoNumbersException(
    message: String = "There cannot be a space between two numbers with no operator between them"
): UserGuidanceException() {
    override val message: String
        get() = "${super.message} $message"
}