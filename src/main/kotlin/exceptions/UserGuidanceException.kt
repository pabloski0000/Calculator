package exceptions

open class UserGuidanceException(
    override val message: String = getDefaultMessage
): RuntimeException() {
    companion object{
        val getDefaultMessage = "User Warning: "
    }
}