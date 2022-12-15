
import mathematicalSymbols.ArithmeticalElement
import mathematicalSymbols.OperatorSymbol
import mathematicalSymbols.RationalNumber
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
            RationalNumber(stringWithOneNumber.toDouble())
        )
        val listForBlankString = emptyList<ArithmeticalElement>()
        val stringOperationWithSpaces = "3.0 + -8.0 * 1.0 - 5.0 / 3.0 * 5.0 * 99.0 / 51.23333339 * 6563.435453 - -1.0" +
                " / 21.15 + 545.45 + 546358743.43543244"
        val listOperationWithSpaces = listOf<ArithmeticalElement>(
            RationalNumber(3.0),
            OperatorSymbol.ADDITION,
            RationalNumber(-8.00),
            OperatorSymbol.MULTIPLICATION,
            RationalNumber(1.0),
            OperatorSymbol.SUBTRACTION,
            RationalNumber(5.0),
            OperatorSymbol.DIVISION,
            RationalNumber(3.0),
            OperatorSymbol.MULTIPLICATION,
            RationalNumber(5.0),
            OperatorSymbol.MULTIPLICATION,
            RationalNumber(99.0),
            OperatorSymbol.DIVISION,
            RationalNumber(51.23333339),
            OperatorSymbol.MULTIPLICATION,
            RationalNumber(6563.435453),
            OperatorSymbol.SUBTRACTION,
            RationalNumber(-1.0),
            OperatorSymbol.DIVISION,
            RationalNumber(21.15),
            OperatorSymbol.ADDITION,
            RationalNumber(545.45),
            OperatorSymbol.ADDITION,
            RationalNumber(5.463587434354324E8),
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
        val test = this.test::splitOperationIntoOperandsAndOperators
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
            RationalNumber(3.0), OperatorSymbol.ADDITION, RationalNumber(-8.0), OperatorSymbol.MULTIPLICATION,
            RationalNumber(1.0), OperatorSymbol.SUBTRACTION, RationalNumber(5.0), OperatorSymbol.DIVISION,
            RationalNumber(3.0)
        )

        assertEquals(adaptedOperation, test(operationElements))
    }
}