package businessRules

fun sum(firstValue: Int, secondValue: Int): Int{
    return firstValue + secondValue
}

fun subtract(firstValue: Int, secondValue: Int): Int{
    return firstValue - secondValue
}

fun multiply(firstValue: Int, secondValue: Int): Int{
    return firstValue * secondValue
}

fun divide(dividend: Int, divisor: Int): Double{
    val divisorAsDouble: Double = divisor.toDouble()
    return dividend.div(divisorAsDouble)
}
class PublicFunctions{
    fun mul(firstOperand: Int, secondOperand: Int): Int{
        return firstOperand * secondOperand
    }
}
