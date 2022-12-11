import mathematicalSymbols.ArithmeticalSymbol
import mathematicalSymbols.NumberSymbol
import mathematicalSymbols.TypeOfOperator
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CommandLineCalculatorKtTest{
    @Test
    fun parseStringOperationToListOperationTest(){
        val functionToTest = ::parseStringOperationToListOperation
        val emptyString = ""
        val emptyListOperation: List<ArithmeticalSymbol> = emptyList()
        val blankString = "     "
        val stringWithOneNumber = "1"
        val expectedListWhenOneNumber = listOf<ArithmeticalSymbol>(
            NumberSymbol(stringWithOneNumber.toDouble())
        )
        val listForBlankString = emptyList<ArithmeticalSymbol>()
        val stringOperationWithSpaces = "3.0 + -8.0 * 1.0 - 5.0 / 3.0 * 5.0 * 99.0 / 51.23333339 * 6563.435453 - -1.0" +
                " / 21.15 + 545.45 + 546358743.43543244"
        val listOperationWithSpaces = listOf<ArithmeticalSymbol>(
            NumberSymbol(3.0),
            TypeOfOperator.ADDITION,
            NumberSymbol(-8.00),
            TypeOfOperator.MULTIPLICATION,
            NumberSymbol(1.0),
            TypeOfOperator.SUBTRACTION,
            NumberSymbol(5.0),
            TypeOfOperator.DIVISION,
            NumberSymbol(3.0),
            TypeOfOperator.MULTIPLICATION,
            NumberSymbol(5.0),
            TypeOfOperator.MULTIPLICATION,
            NumberSymbol(99.0),
            TypeOfOperator.DIVISION,
            NumberSymbol(51.23333339),
            TypeOfOperator.MULTIPLICATION,
            NumberSymbol(6563.435453),
            TypeOfOperator.SUBTRACTION,
            NumberSymbol(-1.0),
            TypeOfOperator.DIVISION,
            NumberSymbol(21.15),
            TypeOfOperator.ADDITION,
            NumberSymbol(545.45),
            TypeOfOperator.ADDITION,
            NumberSymbol(5.463587434354324E8),
        )
        val stringOperationWithIntegersNumbers = "3 + -8 * 1 - 5 / 3 * 5 * 99 / 51 * 6563 - -1" +
                " / 21 + 545 + 546358743"
        val expectedOutputs = mapOf(
            Pair(stringOperationWithSpaces, listOperationWithSpaces),
            Pair(stringWithOneNumber, expectedListWhenOneNumber),
            Pair(blankString, listForBlankString),
            Pair(emptyString, emptyListOperation),
        )
        for((input, expectedOutput) in expectedOutputs){
            assertEquals(expectedOutput, functionToTest(input))
        }
    }

    /*@Test
    fun checkIfThereIsOperandFromPosition__FunctionTest(){
        val exampleString: String = "32 + 456 - 54 * 3       "
        val positionsWithOperandsOrOperators = arrayOf(0, 12, 13, 14, 15, 16)
        val positionsWithNoOperandsNorOperators = arrayOf(17, 18, 52)

        val functionToTest = ::checkIfThereIsOperandFromPosition

        for (position in positionsWithOperandsOrOperators){
            assertEquals(true, functionToTest(exampleString, position))
        }
        for(position in positionsWithNoOperandsNorOperators){
            assertEquals(false, functionToTest(exampleString, position))
        }
    }
    @Test
    fun nextOperand__FunctionTest(){
        val expectedValues = arrayOf(Operand(123), Operand(456), Operand(789), Operand(123))
        val exampleString = "${expectedValues[0]} + ${expectedValues[1]} - ${expectedValues[2]} / ${expectedValues[3]} "
        val startPositions = arrayOf(0, 6, 12, 18)

        var functionToTest = ::nextOperand

        for (i in 0..3){
            assertEquals(expectedValues[i], functionToTest(exampleString, startPositions[i]))
        }
    }
    @Test
    fun getNextOperandEndPositionPlusOne__FunctionTest(){
        val functionToTest = ::getNextOperandEndPositionPlusOne
        val exampleString = "123 + 465 - 789"
        val inputOutputTest = mapOf<Int, Int>(Pair(0, 3), Pair(6, 9), Pair(12, 15))

        for((input, output) in inputOutputTest){
            assertEquals(output, functionToTest(exampleString, input))
        }
    }
    @Test
    fun getNextOperatorStartPosition__FunctionTest(){
        val functionToTest = ::getNextOperatorStartPosition
        val exampleString = "123 + 456 - 789 * 123 /"
        val inputOutputResults = mapOf<Int, Int>(Pair(0, 4), Pair(5, 10), Pair(11, 16), Pair(17, 22))

        for((input, output) in inputOutputResults){
            assertEquals(output, functionToTest(exampleString, input))
        }
    }
    @Test
    fun getNextOperatorEndPositionPlusOne__FunctionTest(){
        val functionToTest = ::getNextOperatorEndPositionPlusOne
        val exampleString = "123 + 456 - 789 * 123 /"
        val inputOutputResults = mapOf<Int, Int>(Pair(4, 5), Pair(10, 11), Pair(16, 17), Pair(22, 23))

        for((input, output) in inputOutputResults){
            assertEquals(output, functionToTest(exampleString, input))
        }
    }
    @Test
    fun calculateFirstOrderSubOperations__FunctionTest(){
        val functionToTest = ::calculateMultiplicationsAndDivisions
        val inputOperation = OperationDataStructure()
        inputOperation.addOperand(9)
        inputOperation.addOperator(ElementaryArithmeticOperators.MULTIPLICATION)
        inputOperation.addOperand(9)
        inputOperation.addOperator(ElementaryArithmeticOperators.DIVISION)
        inputOperation.addOperand(9)
        val outputOperation = OperationDataStructure()
        outputOperation.addOperand(9)
        val inputOutputResults = mapOf(Pair(inputOperation, outputOperation))
        for((input, output) in inputOutputResults){
            assertEquals(output.getOperands()[0], functionToTest(input).getOperands()[0])
        }
    }
    @Test
    fun evaluateOneMultiplicationOrDivision__FunctionTest(){
        val functionToTest = ::evaluateOneMultiplicationOrDivision
        val inputOperation = OperationDataStructure()
        inputOperation.addOperand(9)
        inputOperation.addOperator(ElementaryArithmeticOperators.ADDITION)
        inputOperation.addOperand(9)
        inputOperation.addOperator(ElementaryArithmeticOperators.MULTIPLICATION)
        inputOperation.addOperand(3)
        inputOperation.addOperator(ElementaryArithmeticOperators.ADDITION)
        inputOperation.addOperand(2)
        val expectedOperation = OperationDataStructure()
        expectedOperation.addOperand(9)
        expectedOperation.addOperator(ElementaryArithmeticOperators.ADDITION)
        expectedOperation.addOperand(27)
        expectedOperation.addOperator(ElementaryArithmeticOperators.ADDITION)
        expectedOperation.addOperand(2)
        assertEquals(expectedOperation.toList(), functionToTest(inputOperation.toList()))
    }*/
}