import mathematicalSymbols.TypeOfOperator
import mathematicalSymbols.NumberSymbol
import mathematicalSymbols.ArithmeticalSymbol
import java.lang.RuntimeException

class Calculator {
    fun calculate(operation: List<ArithmeticalSymbol>): List<ArithmeticalSymbol>{
        val operationElements: MutableList<ArithmeticalSymbol> = operation.toMutableList()
        var firstOperand: NumberSymbol = NumberSymbol(.0)
        var secondOperand: NumberSymbol
        var whileCursor = 1
        while (whileCursor < operationElements.size){
            firstOperand = operationElements[whileCursor - 1] as NumberSymbol
            secondOperand = operationElements[whileCursor + 1] as NumberSymbol
            var multiplicationOrDivisionDone = false
            multiplicationOrDivisionDone = when(operationElements[whileCursor]){
                TypeOfOperator.MULTIPLICATION -> {
                    firstOperand = NumberSymbol(firstOperand.toDouble() * secondOperand.toDouble())
                    true
                }
                TypeOfOperator.DIVISION -> {
                    firstOperand = NumberSymbol(firstOperand.toDouble() / secondOperand.toDouble())
                    true
                }
                else -> false
            }
            if (multiplicationOrDivisionDone){
                operationElements[whileCursor - 1] = firstOperand
                operationElements.removeAt(whileCursor)
                operationElements.removeAt(whileCursor)
            }else{
                whileCursor += 2
            }
        }
        for (index in 1 until operationElements.size step 2){
            if(index == 1)
                firstOperand = operationElements[index - 1] as NumberSymbol
            secondOperand = operationElements[index + 1] as NumberSymbol
            firstOperand = when(operationElements[index]){
                TypeOfOperator.ADDITION -> NumberSymbol(firstOperand.toDouble() + secondOperand.toDouble())
                TypeOfOperator.SUBTRACTION -> NumberSymbol(firstOperand.toDouble() - secondOperand.toDouble())
                else -> throw RuntimeException("Unrecognised opertor symbol")
            }
        }
        return listOf<ArithmeticalSymbol>(
            firstOperand
        )
    }
}