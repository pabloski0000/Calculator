
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class OperationTokenizerTest {
    @Test
    fun getFirstOperandWhenBlankString(){
        val emptyOperation = ""
        val blankOperation = "  "
        val expectedErrorMessage = "You must pass an operation with at least one operand"

        try {
            OperationTokenizer(emptyOperation)
        }catch (e: RuntimeException){
            assertEquals(expectedErrorMessage, e.message)
        }
        try {
            OperationTokenizer(blankOperation)
        }catch (e: RuntimeException){
            assertEquals(expectedErrorMessage, e.message)
        }
    }
    @Test
    fun getNextOperandWhenItIsNegative(){
        val oneNegativeOperand = "-1"
        val toTest = OperationTokenizer(oneNegativeOperand)

        assertEquals(oneNegativeOperand, toTest.nextOperand())
    }
    @Test
    fun tokenizeAWholeOperation(){
        val operation = "3+4*8/3--3+8   * 3.3 --2.35"
        val expectedTokensInOrder = arrayOf(
            "3","+","4","*","8","/","3","-","-3","+","8","*","3.3","-","-2.35"
        )
        val toTest = OperationTokenizer(operation)

        var cursor = 0
        assertEquals(expectedTokensInOrder[cursor], toTest.nextOperand())
        ++cursor
        while (toTest.hasNext()){
            assertEquals(expectedTokensInOrder[cursor], toTest.nextOperator())
            ++cursor
            assertEquals(expectedTokensInOrder[cursor], toTest.nextOperand())
            ++cursor
        }
    }
}