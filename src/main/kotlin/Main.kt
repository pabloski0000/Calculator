import businessRules.*
import java.lang.RuntimeException
import java.util.Scanner

fun main(args: Array<String>) {
    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    val scanner: Scanner = Scanner(System.`in`)
    do {
        println("Print your operation then press enter")
        val operation: String = scanner.nextLine()
        val result = calculateStringOperation(operation)
        val resultPresented: String = if(result.toDouble() % 1 == 0.0)
            result.toInt().toString()
        else
            result.toString()
        println("This result is $resultPresented")
        var userWantToContinueWithTheProgram: Boolean = true
        println("If you want to skip the program write 'skip' otherwise click on " +
                "'Enter' or write another word and click on 'Enter'")
        val userMessageToSkipOrContinueLowerCase: String = scanner.nextLine().lowercase()
        val messageForSkipProgramLowerCase: String = "skip"
        if(userMessageToSkipOrContinueLowerCase == messageForSkipProgramLowerCase)
            userWantToContinueWithTheProgram = false
    }while (userWantToContinueWithTheProgram)
}