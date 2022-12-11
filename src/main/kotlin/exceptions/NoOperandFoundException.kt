package exceptions

class NoOperandFoundException(
    message: String = "No operand has been found"
): UserGuidanceException() {
    override val message: String
        get() = "${super.message} $message"
}