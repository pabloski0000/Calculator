package exceptions

open class ProgrammerErrorException(
    override val message: String = getDefaultMessage
): RuntimeException() {
    companion object{
        val getDefaultMessage = "Programmer Error: "
    }
}