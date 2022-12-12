
import mathematicalSymbols.ArithmeticalElement
import mathematicalSymbols.Operand
import mathematicalSymbols.OperatorSymbol
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CalculatorTest{
    val classToTest: Calculator = Calculator()
    var defaultOperation: List<ArithmeticalElement> = emptyList()
    @BeforeEach
    fun setUp(){
        defaultOperation = listOf(
            Operand(3.0),
            OperatorSymbol.ADDITION,
            Operand(-8.00),
            OperatorSymbol.MULTIPLICATION,
            Operand(1.0),
            OperatorSymbol.SUBTRACTION,
            Operand(2.0),
            OperatorSymbol.DIVISION,
            Operand(3.0),
            OperatorSymbol.MULTIPLICATION,
            Operand(5.0),
        )
    }
    @Test
    fun firstAdditionHasBeenDoneCorrectly(){
        val functionToTest = classToTest::calculate
        val inputList = listOf<ArithmeticalElement>(
            Operand(3.0),
            OperatorSymbol.ADDITION,
            Operand(-8.00),
            OperatorSymbol.MULTIPLICATION,
            Operand(1.0),
            OperatorSymbol.SUBTRACTION,
            Operand(2.0),
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
            OperatorSymbol.MULTIPLICATION,
            Operand(21.15),
            OperatorSymbol.ADDITION,
            Operand(5435.45),
            OperatorSymbol.ADDITION,
            Operand(5463543.43543244),
        )
        val expectedResultList = listOf<ArithmeticalElement>(
            Operand(3.0 + (-8.0) * 1.0 - 2.0 / 3.0 * 5.0 * 99.0 / 51.23333339 * 6563.435453 - (-1.0)
                    * 21.15 + 5435.45 + 5463543.43543244)
        )

        assertEquals(expectedResultList, functionToTest(inputList))
    }
}