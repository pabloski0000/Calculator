class Subtraction(
    val minuend: RationalNumberOrArithmeticOperator,
    val subtrahend: RationalNumberOrArithmeticOperator
): ElementaryArithmeticOperator(minuend, subtrahend) {

    override fun equals(): RationalNumber {
        val difference = minuend.equals().value - secondOperand.equals().value
        return RationalNumber(difference)
    }
}