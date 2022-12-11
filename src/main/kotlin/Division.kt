class Division(
    val dividend: RationalNumberOrArithmeticOperator,
    val divisor: RationalNumberOrArithmeticOperator
): ElementaryArithmeticOperator(dividend, divisor) {
    override fun equals(): RationalNumber {
        val fraction = dividend.equals().value / divisor.equals().value
        return RationalNumber(fraction)
    }
}