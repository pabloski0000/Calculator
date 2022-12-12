
import mathematicalSymbols.ArithmeticalElement
import mathematicalSymbols.Operand
import mathematicalSymbols.OperatorSymbol

class Calculator {
    fun calculate(operation: List<ArithmeticalElement>): List<ArithmeticalElement>{
        val operationElements: MutableList<ArithmeticalElement> = operation.toMutableList()
        var firstOperand: Operand = Operand(.0)
        var secondOperand: Operand
        var whileCursor = 1
        while (whileCursor < operationElements.size){
            firstOperand = operationElements[whileCursor - 1] as Operand
            secondOperand = operationElements[whileCursor + 1] as Operand
            var multiplicationOrDivisionDone = false
            multiplicationOrDivisionDone = when(operationElements[whileCursor]){
                OperatorSymbol.MULTIPLICATION -> {
                    firstOperand = Operand(firstOperand.toDouble() * secondOperand.toDouble())
                    true
                }
                OperatorSymbol.DIVISION -> {
                    firstOperand = Operand(firstOperand.toDouble() / secondOperand.toDouble())
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
                firstOperand = operationElements[index - 1] as Operand
            secondOperand = operationElements[index + 1] as Operand
            firstOperand = when(operationElements[index]){
                OperatorSymbol.ADDITION -> Operand(firstOperand.toDouble() + secondOperand.toDouble())
                OperatorSymbol.SUBTRACTION -> Operand(firstOperand.toDouble() - secondOperand.toDouble())
                else -> throw RuntimeException("Unrecognised opertor symbol")
            }
        }
        return listOf<ArithmeticalElement>(
            firstOperand
        )
    }
}