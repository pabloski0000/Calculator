import mathematicalSymbols.ArithmeticalElement
import mathematicalSymbols.Operand
import mathematicalSymbols.Operator
import java.lang.RuntimeException
import java.util.*

fun calculateStringOperation(operation: String): Double {
    val operationList: List<ArithmeticalElement> = parseStringOperationToListOperation(operation)
    val operationListCalculated: List<ArithmeticalElement> = Calculator().calculate(operationList)
    val result = operationListCalculated[0] as Operand
    return result.toDouble()
}

fun parseStringOperationToListOperation(stringOperation: String): List<ArithmeticalElement>{
    val validOperatorCharacters = listOf("+", "-", "*", "/")
    if(stringOperation.isBlank())
        return emptyList()
    val operationList: MutableList<ArithmeticalElement> = mutableListOf()
    val scanner: OperationScanner = OperationScanner(stringOperation, validOperatorCharacters)
    val adaptOperand = { operand: Double -> Operand(operand)}
    val adaptOperator = { operator: String -> when(operator){
        "+" -> Operator.ADDITION
        "-" -> Operator.SUBTRACTION
        "*" -> Operator.MULTIPLICATION
        "/" -> Operator.DIVISION
        else -> throw RuntimeException("Type of operator not recognised")
    }}
    val firstOperand: Double = scanner.nextDouble()
    operationList.add(adaptOperand(firstOperand))
    while (scanner.hasNext()){
        val operatorSymbol: String = scanner.nextOperatorSymbol()
        val secondOperand: Double = scanner.nextDouble()
        operationList.add(adaptOperator(operatorSymbol))
        operationList.add(adaptOperand(secondOperand))
    }
    return operationList
}

/*fun convertStringToOperation(stringOperation: String): () -> Double{
    val operation: () -> Double = { 0.0 }
    val operationDataStructure = mutableListOf<RationalNumberOrArithmeticOperator>()
    var operator: ElementaryArithmeticOperators
    var cursor: Int
    if(checkIfThereIsOperandFromPosition(stringOperation, 0)){
        cursor = getNextOperandStartPosition(stringOperation, 0)
        if(cursor == -1){
            throw InconsistentLogicException("${ProgrammerErrorException.getDefaultMessage}" +
                    "'getNextOperandStartPosition()' function must return the actual" +
                    "position of the next operand because its existence in the operation was already checked")
        }
        //operand = nextOperand(stringOperation, cursor)
        //operationDataStructure.add(operand)
        cursor = getNextOperandEndPositionPlusOne(stringOperation, cursor)
    }else{
        return operation
    }
    do {
        var continueReadingStringOperation = true
        if(checkIfThereIsOperatorFromPosition(stringOperation, cursor)){
            cursor = getNextOperatorStartPosition(stringOperation, cursor)
            operator = nextOperator(stringOperation, cursor)
            //operationDataStructure.add(operator)
            cursor = getNextOperatorEndPositionPlusOne(stringOperation, cursor)
        }else{
            continueReadingStringOperation = false
        }
        if(continueReadingStringOperation && checkIfThereIsOperandFromPosition(stringOperation, cursor)){
            cursor = getNextOperandStartPosition(stringOperation, cursor)
            if(cursor == -1){
                throw InconsistentLogicException("${ProgrammerErrorException.getDefaultMessage}" +
                        "'getNextOperandStartPosition()' function must return the actual" +
                        "position of the next operand because its existence in the operation was already checked")
            }
            //operand = nextOperand(stringOperation, cursor)
            //operationDataStructure.add(operand)
            cursor = getNextOperandEndPositionPlusOne(stringOperation, cursor)
        }else if (continueReadingStringOperation){
            throw NoOperandFoundException("${UserGuidanceException.getDefaultMessage} There must be" +
                    "at least one operand after an operator")
        }
    }while (continueReadingStringOperation)

    return operation
}

fun createOperationFromDataStructure(dataStructure: List<RationalNumberOrArithmeticOperator>){

}

fun calculateMultiplicationsAndDivisions(operation: List<RationalNumberOrArithmeticOperator>): List<RationalNumberOrArithmeticOperator>{
    var unprocessedOperation: List<RationalNumberOrArithmeticOperator> = operation
    var processedOperation: List<RationalNumberOrArithmeticOperator> = emptyList()
    val operationWithMultiplicationsAndDivisionCalculated: OperationDataStructure = RationalNumberOrArithmeticOperator()
    var firstOperandToOperateOn: Int
    var secondOperandToOperateOn: Int
    var cursor: Int = 1
    while(processedOperation != unprocessedOperation){
        unprocessedOperation = processedOperation
        processedOperation = evaluateOneMultiplicationOrDivision(unprocessedOperation)
    }
    return operationWithMultiplicationsAndDivisionCalculated
}

fun evaluateOneMultiplicationOrDivision(operation: List<RationalNumberOrArithmeticOperator>): List<Any>{
    val operandCreator: (value: Double) -> Operand = {value -> Operand(value)}
    Division(operandCreator, Operand(2.0))
    val processedOperation: MutableList<Any> = mutableListOf()
    var cursor = 0
    while(cursor < operation.size){
        when(operation[cursor]){
            ElementaryArithmeticOperators.MULTIPLICATION -> {
                val result = (operation[cursor - 1] as Int) * (operation[cursor + 1] as Int)
                processedOperation[processedOperation.lastIndex] = result
                ++cursor
            }
            ElementaryArithmeticOperators.DIVISION -> {
                val result = (operation[cursor - 1] as Int) / (operation[cursor + 1] as Int)
                processedOperation[processedOperation.lastIndex] = result
                ++cursor
            }
            else -> processedOperation.add(operation[cursor])
        }
        ++cursor
    }
    return processedOperation
}

fun checkIfThereIsOperandFromPosition(string: String, position: Int): Boolean{
    var currentChar: Char
    for (i in position until string.length){
        currentChar = string[i]
        if(currentChar.isDigit())
            return true
    }
    return false
}

fun checkIfThereIsOperatorFromPosition(string: String, position: Int): Boolean{
    val possibleOperators: List<Char> = acceptedClientOperators()
    var currentChar: Char
    for (i in position until string.length){
        currentChar = string[i]
        if(currentChar in possibleOperators)
            return true
    }
    return false
}

fun getNextOperandEndPositionPlusOne(string: String, startPositionOfOperand: Int): Int{
    val cursorStartPosition = startPositionOfOperand + 1
    for(cursorPosition in cursorStartPosition until string.length){
        if(!string[cursorPosition].isDigit()){
            return cursorPosition
        }
    }
    return string.length
}

fun getNextOperatorEndPositionPlusOne(string: String, startPositionOfOperator: Int): Int{
    if(acceptedClientOperators() is List<Char>)
        return startPositionOfOperator + 1
    else
        throw InconsistentLogicException("${ProgrammerErrorException.getDefaultMessage} function not ready" +
                "to deal with non-Char operators")
}

fun getNextOperandStartPosition(string: String, position: Int): Int{
    for(currentPosition in position until string.length){
        if(string[currentPosition].isDigit())
            return currentPosition
    }
    return -1
}

fun getNextOperatorStartPosition(string: String, position: Int): Int{
    val possibleValidOperatorsIntroducedByClient: List<Char> = acceptedClientOperators()
    for (currentPosition in position until string.length){
        if(string[currentPosition] in possibleValidOperatorsIntroducedByClient){
            return currentPosition
        }
    }
    return -1
}

fun nextOperand(string: String, startPositionOperand: Int): Operand{
    val operandBuilder: StringBuilder = StringBuilder()
    var currentPosition = startPositionOperand
    while (currentPosition < string.length && string[currentPosition].isDigit()){
        operandBuilder.append(string[currentPosition])
        ++currentPosition
    }
    return Operand(operandBuilder.toString().toInt())
}

fun nextOperator(string: String, operatorPosition: Int): ElementaryArithmeticOperators{
    return when(string[operatorPosition]){
        acceptedAdditionClientOperator() -> ElementaryArithmeticOperators.ADDITION
        acceptedSubtractionClientOperator() -> ElementaryArithmeticOperators.SUBTRACTION
        acceptedMultiplicationClientOperator() -> ElementaryArithmeticOperators.MULTIPLICATION
        acceptedDivisionClientOperator() -> ElementaryArithmeticOperators.DIVISION
        else -> throw UnrecognizedOperatorException(string[operatorPosition])
    }
}

fun acceptedClientOperators() =
    listOf(
        acceptedAdditionClientOperator(),
        acceptedSubtractionClientOperator(),
        acceptedMultiplicationClientOperator(),
        acceptedDivisionClientOperator()
    )

fun acceptedAdditionClientOperator() = '+'
fun acceptedSubtractionClientOperator() = '-'
fun acceptedMultiplicationClientOperator() = '*'
fun acceptedDivisionClientOperator() = '/'*/
