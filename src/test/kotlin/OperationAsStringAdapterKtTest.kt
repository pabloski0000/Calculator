import mathematicalSymbols.ArithmeticalElement
import mathematicalSymbols.Operand
import mathematicalSymbols.OperatorSymbol
import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

class OperationAsStringAdapterTest{
    val test = OperationAsStringAdapter()
    @Test
    fun parseStringOperationToListOperationTest(){
        val test = this.test::adaptOperation
        val stringWithOneNumber = "1"
        val expectedListWhenOneNumber = listOf<ArithmeticalElement>(
            Operand(stringWithOneNumber.toDouble())
        )
        val listForBlankString = emptyList<ArithmeticalElement>()
        val stringOperationWithSpaces = "3.0 + -8.0 * 1.0 - 5.0 / 3.0 * 5.0 * 99.0 / 51.23333339 * 6563.435453 - -1.0" +
                " / 21.15 + 545.45 + 546358743.43543244"
        val listOperationWithSpaces = listOf<ArithmeticalElement>(
            Operand(3.0),
            OperatorSymbol.ADDITION,
            Operand(-8.00),
            OperatorSymbol.MULTIPLICATION,
            Operand(1.0),
            OperatorSymbol.SUBTRACTION,
            Operand(5.0),
            OperatorSymbol.DIVISION,
            Operand(3.0),
            OperatorSymbol.MULTIPLICATION,
            Operand(5.0),
            OperatorSymbol.MULTIPLICATION,
            Operand(99.0),
            OperatorSymbol.DIVISION,
            Operand(51.23333339),
            OperatorSymbol.MULTIPLICATION,
            Operand(6563.435453),
            OperatorSymbol.SUBTRACTION,
            Operand(-1.0),
            OperatorSymbol.DIVISION,
            Operand(21.15),
            OperatorSymbol.ADDITION,
            Operand(545.45),
            OperatorSymbol.ADDITION,
            Operand(5.463587434354324E8),
        )
        val stringOperationWithIntegersNumbers = "3 + -8 * 1 - 5 / 3 * 5 * 99 / 51 * 6563 - -1" +
                " / 21 + 545 + 546358743"
        val expectedOutputs = mapOf(
            Pair(stringOperationWithSpaces, listOperationWithSpaces),
            Pair(stringWithOneNumber, expectedListWhenOneNumber),
        )
        for((input, expectedOutput) in expectedOutputs){
            assertEquals(expectedOutput, test(input))
        }
    }

    @Test
    fun splitStringOperationIntoOperandsAndOperatorsTest(){
        val test = this.test::splitStringOperationIntoOperandsAndOperators
        val operationWithSpaces = "3 + -8 * 1 - 5 / 3 * 5 * 99 / 51 * 6563 - -1" +
                " / 21 + 545 + 546358743"
        val expectedList = arrayOf(
            "3", "+", "-8", "*", "1", "-", "5", "/", "3", "*", "5", "*", "99", "/", "51", "*",
            "6563", "-", "-1", "/", "21", "+", "545", "+", "546358743"
        )

        assertContentEquals(expectedList, test(operationWithSpaces))
    }

    @Test
    fun adaptOperationElementsWell(){
        val test = this.test::adaptOperandsAndOperators
        val operationElements = arrayOf(
            "3", "+", "-8", "*", "1", "-", "5", "/", "3",
        )
        val adaptedOperation = listOf(
            Operand(3.0), OperatorSymbol.ADDITION, Operand(-8.0), OperatorSymbol.MULTIPLICATION,
            Operand(1.0), OperatorSymbol.SUBTRACTION, Operand(5.0), OperatorSymbol.DIVISION,
            Operand(3.0)
        )

        assertEquals(adaptedOperation, test(operationElements))
    }
}