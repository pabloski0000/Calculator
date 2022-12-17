import java.io.Console

fun main(args: Array<String>) {
    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    val console: Console = System.console()
    val calculator = Calculator()
    val operationAdapter = OperationAsStringAdapter()
    do {
        val operation = console.readLine("Print your operation then press enter\n")
        val result = calculator.calculate(operationAdapter.adaptOperation(operation))
        val resultPresented: String = if(result.toDouble() % 1 == 0.0)
            result.toInt().toString()
        else
            result.toString()
        println("This result is $resultPresented")
        var userWantToContinueWithTheProgram: Boolean = true
        val userMessageToSkipOrContinueLowerCase: String = console.readLine("If you want to skip the program" +
                " write 'skip' otherwise click on 'Enter' or write another word and click on 'Enter'\n")
            .lowercase()
        val messageForSkipProgramLowerCase: String = "skip"
        if(userMessageToSkipOrContinueLowerCase == messageForSkipProgramLowerCase)
            userWantToContinueWithTheProgram = false
    }while (userWantToContinueWithTheProgram)
}