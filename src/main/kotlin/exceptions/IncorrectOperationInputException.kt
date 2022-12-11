package exceptions

import java.lang.RuntimeException

class IncorrectOperationInputException(
    message: String = "The input operation has incorrect format"
): UserGuidanceException() {
    override val message: String
        get() = "${super.message} $message"
}