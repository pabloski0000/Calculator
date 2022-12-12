
import mathematicalSymbols.ArithmeticalElement
import mathematicalSymbols.Operand
import mathematicalSymbols.OperatorSymbol
import java.util.*

class OperationAsStringAdapter {
    private val additionSymbol = "+"
    private val subtractionSymbol = "-"
    private val multiplicationSymbol = "*"
    private val divisionSymbol = "/"
    fun calculateStringOperation(operation: String): Double {
        if(operation.isBlank())
            throw RuntimeException("The operation at least has to contain one operand")
        val operationList: List<ArithmeticalElement> = adaptOperation(operation)
        val operationListCalculated: List<ArithmeticalElement> = Calculator().calculate(operationList)
        val result = operationListCalculated[0] as Operand
        return result.toDouble()
    }

    fun adaptOperation(operation: String): List<ArithmeticalElement>{
        val operationSplit = splitStringOperationIntoOperandsAndOperators(operation)
        val adaptedOperation = adaptOperandsAndOperators(operationSplit)
        return adaptedOperation
    }

    fun splitStringOperationIntoOperandsAndOperators(operation: String): Array<String>{
        val operationWithoutSpaces = operation.replace(" ", "")
        val allOperators = additionSymbol + subtractionSymbol + multiplicationSymbol + divisionSymbol
        val tokenizer = StringTokenizer(operationWithoutSpaces, allOperators, true)
        val operandsAndOperatorsSplit: MutableList<String> = mutableListOf()
        val firstOperand = StringBuilder(tokenizer.nextToken())
        if (firstOperand.toString() in allOperators){
            firstOperand.append(tokenizer.nextToken())
        }
        operandsAndOperatorsSplit.add(firstOperand.toString())
        while (tokenizer.hasMoreTokens()){
            val operator = tokenizer.nextToken()
            operandsAndOperatorsSplit.add(operator)
            val operand = StringBuilder(tokenizer.nextToken())
            if(operand.toString() in allOperators){
                operand.append(tokenizer.nextToken())
            }
            operandsAndOperatorsSplit.add(operand.toString())
        }
        return operandsAndOperatorsSplit.toTypedArray()
    }

    fun adaptOperandsAndOperators(operation: Array<String>): List<ArithmeticalElement>{
        val adaptedOperation = mutableListOf<ArithmeticalElement>()
        val firstOperand = operation[0]
        adaptedOperation.add(adaptOperand(firstOperand))
        var cursor = 1
        while (cursor < operation.size){
            val operator = operation[cursor]
            adaptedOperation.add(adaptOperator(operator))
            ++cursor
            val operand = operation[cursor]
            adaptedOperation.add(adaptOperand(operand))
            ++cursor
        }
        return adaptedOperation
    }

    private fun adaptOperand(operand: String) = Operand(operand.toDouble())

    private fun adaptOperator(operator: String): OperatorSymbol{
        return when(operator){
            additionSymbol -> OperatorSymbol.ADDITION
            subtractionSymbol -> OperatorSymbol.SUBTRACTION
            multiplicationSymbol -> OperatorSymbol.MULTIPLICATION
            divisionSymbol -> OperatorSymbol.DIVISION
            else -> throw RuntimeException("Type of operator not recognised")
        }
    }
}

