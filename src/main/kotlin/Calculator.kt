
import mathematicalSymbols.ArithmeticalElement
import mathematicalSymbols.OperatorSymbol
import mathematicalSymbols.RationalNumber
class Calculator {
    fun calculate(operation: List<ArithmeticalElement>): Double{
        if(operation.isEmpty())
            return .0
        if(isOperationSizeEqualsOne(operation)){
            return getFirstOperand(operation)
        }
        return performMultiplicationsAndDivisionsFirstAndThenAdditionsAndSubtractions(operation.toMutableList())
    }

    private fun isOperationSizeEqualsOne(operation: List<ArithmeticalElement>): Boolean{
        return operation.size == 1
    }

    private fun getFirstOperand(operation: List<ArithmeticalElement>): Double{
        return adaptToRationalNumber(operation[0]).toDouble()
    }

    private fun performMultiplicationsAndDivisionsFirstAndThenAdditionsAndSubtractions(operation: MutableList<ArithmeticalElement>): Double{
        val operationWithoutMultiplicationNorDivisions = performMultiplicationsAndDivisions(operation)
        val result = performAdditionsAndSubtractions(operationWithoutMultiplicationNorDivisions)
        return result.toDouble()
    }

    private fun performMultiplicationsAndDivisions(operation: List<ArithmeticalElement>): List<ArithmeticalElement>{
        var operationToOperateOn = operation.toMutableList()
        var cursor = 1
        while (cursor < operationToOperateOn.size){
            val operatorPosition = cursor
            when(operationToOperateOn[cursor]){
                OperatorSymbol.MULTIPLICATION -> {
                    operationToOperateOn = performMultiplicaionOnList(operationToOperateOn, operatorPosition)
                }
                OperatorSymbol.DIVISION -> {
                    operationToOperateOn = performDivisionOnList(operationToOperateOn, operatorPosition)
                }
                else -> cursor += 2
            }
        }
        return operationToOperateOn
    }

    private fun performMultiplicaionOnList(operation: MutableList<ArithmeticalElement>, operatorPosition: Int): MutableList<ArithmeticalElement>{
        val firstOperandPosition = operatorPosition - 1
        val secondOperandPosition = operatorPosition + 1
        val firstOperand = adaptToRationalNumber(operation[firstOperandPosition]).toDouble()
        val secondOperand = adaptToRationalNumber(operation[secondOperandPosition]).toDouble()
        val result = multiplicate(firstOperand, secondOperand)
        operation[firstOperandPosition] = adaptToRationalNumber(result)
        operation.removeAt(secondOperandPosition)
        operation.removeAt(operatorPosition)
        return operation
    }
    fun multiplicate(multiplier: Double, multiplicand: Double) = multiplier * multiplicand

    private fun performDivisionOnList(operation: MutableList<ArithmeticalElement>, operatorPosition: Int): MutableList<ArithmeticalElement>{
        val firstOperandPosition = operatorPosition - 1
        val secondOperandPosition = operatorPosition + 1
        val firstOperand = adaptToRationalNumber(operation[firstOperandPosition]).toDouble()
        val secondOperand = adaptToRationalNumber(operation[secondOperandPosition]).toDouble()
        val result = divide(firstOperand, secondOperand)
        operation[firstOperandPosition] = adaptToRationalNumber(result)
        operation.removeAt(secondOperandPosition)
        operation.removeAt(operatorPosition)
        return operation
    }
    fun divide(dividend: Double, divisor: Double) = dividend / divisor

    private fun performAdditionsAndSubtractions(operations: List<ArithmeticalElement>): RationalNumber{
        var firstOperand: RationalNumber = adaptToRationalNumber(operations[0])
        var secondOperand: RationalNumber
        for (index in 1 until operations.size step 2){
            secondOperand = adaptToRationalNumber(operations[index + 1])
            firstOperand = when(operations[index]){
                OperatorSymbol.ADDITION -> RationalNumber(firstOperand.toDouble() + secondOperand.toDouble())
                OperatorSymbol.SUBTRACTION -> RationalNumber(firstOperand.toDouble() - secondOperand.toDouble())
                else -> throw RuntimeException("Unrecognised opertor symbol")
            }
        }
        return firstOperand
    }

    private fun adaptToRationalNumber(arithmeticalElement: ArithmeticalElement): RationalNumber{
        return arithmeticalElement as RationalNumber
    }

    private fun adaptToRationalNumber(operand: Double): RationalNumber{
        return RationalNumber(operand)
    }
}