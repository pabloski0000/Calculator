import mathematicalSymbols.Operator
import mathematicalSymbols.Operand
import mathematicalSymbols.ArithmeticalElement
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CalculatorTest{
    val classToTest: Calculator = Calculator()
    var defaultOperation: List<ArithmeticalElement> = emptyList()
    @BeforeEach
    fun setUp(){
        defaultOperation = listOf(
            Operand(3.0),
            Operator.ADDITION,
            Operand(-8.00),
            Operator.MULTIPLICATION,
            Operand(1.0),
            Operator.SUBTRACTION,
            Operand(2.0),
            Operator.DIVISION,
            Operand(3.0),
            Operator.MULTIPLICATION,
            Operand(5.0),
        )
    }
    @Test
    fun firstAdditionHasBeenDoneCorrectly(){
        val functionToTest = classToTest::calculate
        val inputList = listOf<ArithmeticalElement>(
            Operand(3.0),
            Operator.ADDITION,
            Operand(-8.00),
            Operator.MULTIPLICATION,
            Operand(1.0),
            Operator.SUBTRACTION,
            Operand(2.0),
            Operator.DIVISION,
            Operand(3.0),
            Operator.MULTIPLICATION,
            Operand(5.0),
            Operator.MULTIPLICATION,
            Operand(99.0),
            Operator.DIVISION,
            Operand(51.23333339),
            Operator.MULTIPLICATION,
            Operand(6563.435453),
            Operator.SUBTRACTION,
            Operand(-1.0),
            Operator.MULTIPLICATION,
            Operand(21.15),
            Operator.ADDITION,
            Operand(5435.45),
            Operator.ADDITION,
            Operand(5463543.43543244),
        )
        val expectedResultList = listOf<ArithmeticalElement>(
            Operand(3.0 + (-8.0) * 1.0 - 2.0 / 3.0 * 5.0 * 99.0 / 51.23333339 * 6563.435453 - (-1.0)
                    * 21.15 + 5435.45 + 5463543.43543244)
        )

        assertEquals(expectedResultList, functionToTest(inputList))
    }
}