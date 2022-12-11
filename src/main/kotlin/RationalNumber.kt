class RationalNumber(
    val value: Double
): RationalNumberOrArithmeticOperator {
    override fun equals(): RationalNumber {
        return RationalNumber(value)
    }
    fun toDouble(): Double{
        return value
    }
}