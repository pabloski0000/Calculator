package mathematicalSymbols

class NumberSymbol(
    val value: Double
): ArithmeticalSymbol {
    fun toDouble(): Double{
        return value
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as NumberSymbol

        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }
}