
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class OperationScannerTest{

    @Test
    fun getOperandsAndOperatorsCorrectly(){
        val classToTest: OperationScanner
        val defaultOperation = "0.587+4    -  -545  *564456/ 23134  +4.534*4"
        classToTest = OperationScanner(defaultOperation, listOf("+", "-", "*", "/"))
        val expectedNumbers = listOf(
            0.587,
            4.0,
            -545.0,
            564456.0,
            23134.0,
            4.534,
            4.0,
        )
        val expectedOperators = listOf(
            "+",
            "-",
            "*",
            "/",
            "+",
            "*",
        )

        assertEquals(expectedNumbers[0], classToTest.nextDouble())
        for ((index, expectedOperator) in expectedOperators.withIndex()){
            assertEquals(expectedOperator, classToTest.nextOperatorSymbol())
            assertEquals(expectedNumbers[index + 1], classToTest.nextDouble())
        }
    }
}