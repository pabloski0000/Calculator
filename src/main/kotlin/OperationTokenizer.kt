
import java.util.*

class OperationTokenizer(
    private val operation: String,
    private val operatorSymbols: String
) {
    private val tokenizer = StringTokenizer(removeSpacesFromOperation(operation), operatorSymbols, true)
    private val operands = mutableListOf<String>()
    private val operators = mutableListOf<String>()
    private var nextOperandCursor = 0
    private var nextOperatorCursor = 0

    init {
        if (operation.isBlank())
            throw RuntimeException("You must pass an operation with at least one operand")
        fillOperandsAndOperatorsVariableMembers()
    }

    fun nextOperand(): String{
        val nextOperand = operands[nextOperandCursor]
        increaseNextOperandCursor(1)
        return nextOperand
    }

    fun nextOperator(): String{
        val nextOperator = operators[nextOperatorCursor]
        increaseNextOperantorCursor(1)
        return nextOperator
    }

    fun hasNext(): Boolean{
        return nextOperandCursor < operands.size
    }

    private fun increaseNextOperandCursor(amount: Int){
        nextOperandCursor += amount
    }

    private fun increaseNextOperantorCursor(amount: Int){
        nextOperatorCursor += amount
    }

    private fun fillOperandsAndOperatorsVariableMembers(){
        operands.add(getNextOperand())
        while (tokenizer.hasMoreTokens()){
            operators.add(getNextOperator())
            operands.add(getNextOperand())
        }

    }

    private fun getNextOperand(): String{
        val operand = StringBuilder(tokenizer.nextToken())
        if (isAnOperator(operand.toString()))
            operand.append(tokenizer.nextToken())
        return operand.toString()
    }

    private fun getNextOperator(): String{
        val operator = getNextToken()
        if (isAnOperator(operator))
            return operator
        throw RuntimeException("Exception at returning next operator. This token is not an operator: $operator")
    }

    private fun getNextToken(): String{
        return tokenizer.nextToken()
    }

    private fun removeSpacesFromOperation(operation: String): String{
        return operation.replace(" ", "")
    }

    private fun isAnOperator(token: String): Boolean{
        if (token in operatorSymbols)
            return true
        return false
    }

}