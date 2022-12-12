class OperationScanner(
    operation: String,
    private val validOperators: List<String> = listOf("+", "-", "*", "/")
) {
    private val operation: String
    private var cursor: Int = 0
    init {
        this.operation = operation.replace(" ", "", ignoreCase = true)
        if (!this.operation.contains(Regex("\\d"))){
            throw RuntimeException("To scan the operation there must be at least one number")
        }
    }
    fun nextDouble(): Double{
        val doubleBuilder: StringBuilder = StringBuilder()
        doubleBuilder.append(operation[cursor])
        ++cursor
        while (cursor < operation.length && !validOperators.contains(operation[cursor].toString())){
            doubleBuilder.append(operation[cursor])
            ++cursor
        }
        return doubleBuilder.toString().toDouble()
    }
    fun nextOperatorSymbol(): String{
        val operatorSymbol = operation[cursor]
        ++cursor
        return operatorSymbol.toString()
    }
    fun hasNext(): Boolean{
        return cursor < operation.length
    }
}