
import mathematicalSymbols.ArithmeticalElement
import mathematicalSymbols.OperatorSymbol
import mathematicalSymbols.RationalNumber

class OperationAsStringAdapter {
    private val additionSymbol = "+"
    private val subtractionSymbol = "-"
    private val multiplicationSymbol = "*"
    private val divisionSymbol = "/"

    fun adaptOperation(operation: String): List<ArithmeticalElement>{
        val operationSplit = splitOperationIntoOperandsAndOperators(operation)
        val adaptedOperation = adaptOperandsAndOperators(operationSplit)
        return adaptedOperation
    }

    fun splitOperationIntoOperandsAndOperators(operation: String): Array<String>{
        val tokenizer = getOperationTokenizer(operation)
        val operandsAndOperatorsSplit: MutableList<String> = mutableListOf()
        val firstOperand = tokenizer.nextOperand()
        operandsAndOperatorsSplit.add(firstOperand)
        while (tokenizer.hasNext()){
            operandsAndOperatorsSplit.add(tokenizer.nextOperator())
            operandsAndOperatorsSplit.add(tokenizer.nextOperand())
        }
        return operandsAndOperatorsSplit.toTypedArray()
    }

    private fun getOperationTokenizer(operation: String): OperationTokenizer{
        return OperationTokenizer(operation)
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

    private fun adaptOperand(operand: String) = RationalNumber(operand.toDouble())

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

