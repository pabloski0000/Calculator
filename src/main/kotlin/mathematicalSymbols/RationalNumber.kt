package mathematicalSymbols

class RationalNumber(
    private val value: Number
): ArithmeticalElement {
    fun toDouble(): Double{
        return value.toDouble()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as RationalNumber

        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }

}