class Multiplication(
    val multiplier: RationalNumberOrArithmeticOperator,
    val multiplicand: RationalNumberOrArithmeticOperator
): ElementaryArithmeticOperator(multiplier, multiplicand) {

    override fun equals(): RationalNumber {
        val product = multiplier.equals().value * multiplicand.equals().value
        return RationalNumber(product)
    }
}