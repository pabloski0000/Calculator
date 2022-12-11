package exceptions

import java.lang.RuntimeException

class UnrecognizedOperatorException(
    val operator: Char,
    message: String = "This operator: '$operator' cannot be recognized"
): UserGuidanceException() {
    override val message: String
        get() = "${super.message} $message"
}