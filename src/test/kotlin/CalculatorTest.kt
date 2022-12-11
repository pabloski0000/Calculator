import mathematicalSymbols.TypeOfOperator
import mathematicalSymbols.NumberSymbol
import mathematicalSymbols.ArithmeticalSymbol
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CalculatorTest{
    val classToTest: Calculator = Calculator()
    var defaultOperation: List<ArithmeticalSymbol> = emptyList()
    @BeforeEach
    fun setUp(){
        defaultOperation = listOf(
            NumberSymbol(3.0),
            TypeOfOperator.ADDITION,
            NumberSymbol(-8.00),
            TypeOfOperator.MULTIPLICATION,
            NumberSymbol(1.0),
            TypeOfOperator.SUBTRACTION,
            NumberSymbol(2.0),
            TypeOfOperator.DIVISION,
            NumberSymbol(3.0),
            TypeOfOperator.MULTIPLICATION,
            NumberSymbol(5.0),
        )
    }
    @Test
    fun firstAdditionHasBeenDoneCorrectly(){
        val functionToTest = classToTest::calculate
        val inputList = listOf<ArithmeticalSymbol>(
            NumberSymbol(3.0),
            TypeOfOperator.ADDITION,
            NumberSymbol(-8.00),
            TypeOfOperator.MULTIPLICATION,
            NumberSymbol(1.0),
            TypeOfOperator.SUBTRACTION,
            NumberSymbol(2.0),
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
            TypeOfOperator.MULTIPLICATION,
            NumberSymbol(21.15),
            TypeOfOperator.ADDITION,
            NumberSymbol(5435.45),
            TypeOfOperator.ADDITION,
            NumberSymbol(5463543.43543244),
        )
        val expectedResultList = listOf<ArithmeticalSymbol>(
            NumberSymbol(3.0 + (-8.0) * 1.0 - 2.0 / 3.0 * 5.0 * 99.0 / 51.23333339 * 6563.435453 - (-1.0)
                    * 21.15 + 5435.45 + 5463543.43543244)
        )

        assertEquals(expectedResultList, functionToTest(inputList))
    }
}