package exceptions

class InconsistentLogicException(
    message: String = "The logic is inconsistently implemented"
): ProgrammerErrorException() {
    override val message: String
        get() = "${super.message} $message"
}