
import mathematicalSymbols.ArithmeticalElement
import mathematicalSymbols.OperatorSymbol
import mathematicalSymbols.RationalNumber
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CalculatorTest{
    val classToTest: Calculator = Calculator()
    var defaultOperation: List<ArithmeticalElement> = emptyList()
    @BeforeEach
    fun setUp(){
        defaultOperation = listOf(
            RationalNumber(3.0),
            OperatorSymbol.ADDITION,
            RationalNumber(-8.00),
            OperatorSymbol.MULTIPLICATION,
            RationalNumber(1.0),
            OperatorSymbol.SUBTRACTION,
            RationalNumber(2.0),
            OperatorSymbol.DIVISION,
            RationalNumber(3.0),
            OperatorSymbol.MULTIPLICATION,
            RationalNumber(5.0),
        )
    }
    @Test
    fun passAListWithOnlyOneOperand(){
        val toTest = classToTest::calculate
        val inputWithOnlyOneOperand = listOf(RationalNumber(3.0))
        val expectedResult  = 3.0

        assertEquals(expectedResult, toTest(inputWithOnlyOneOperand))
    }
    @Test
    fun firstAdditionHasBeenDoneCorrectly(){
        val toTest = classToTest::calculate
        val inputList = listOf<ArithmeticalElement>(
            RationalNumber(3.0),
            OperatorSymbol.ADDITION,
            RationalNumber(-8.00),
            OperatorSymbol.MULTIPLICATION,
            RationalNumber(1.0),
            OperatorSymbol.SUBTRACTION,
            RationalNumber(2.0),
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
            OperatorSymbol.MULTIPLICATION,
            RationalNumber(21.15),
            OperatorSymbol.ADDITION,
            RationalNumber(5435.45),
            OperatorSymbol.ADDITION,
            RationalNumber(5463543.43543244),
        )
        val expectedResultList: Double = 3.0 + (-8.0) * 1.0 - 2.0 / 3.0 * 5.0 * 99.0 / 51.23333339 * 6563.435453 - (-1.0) * 21.15 + 5435.45 + 5463543.43543244

        assertEquals(expectedResultList, toTest(inputList))
    }
}