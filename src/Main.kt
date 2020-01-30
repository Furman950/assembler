import com.ferminsandoval.Assembler
import java.time.LocalDate

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        if (args.size != 1){
            println("Expected 1 argument, but got ${args.size}")
            return
        }

        Assembler().run(args[0])
    }
}