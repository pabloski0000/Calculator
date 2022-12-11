class Addition(
    val augend: RationalNumberOrArithmeticOperator,
    val addend: RationalNumberOrArithmeticOperator

): ElementaryArithmeticOperator(augend, addend) {

    override fun equals(): RationalNumber {
        val sum = augend.equals().value + addend.equals().value
        return RationalNumber(sum)
    }
}