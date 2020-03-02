package main.kotlin.com.ferminsandoval.states.datatransfer.str

import main.kotlin.com.ferminsandoval.exceptions.InvalidInstructionException
import main.kotlin.com.ferminsandoval.models.Instruction
import main.kotlin.com.ferminsandoval.states.Finished
import main.kotlin.com.ferminsandoval.states.State
import java.lang.Long


class EncodeOffset : State {
    private val MAX_OFFSET = 2047
    override fun nextState(instruction: Instruction): State {
        var offset = instruction.parameters[2]

        if (offset.startsWith("0x")){
            offset = offset.removePrefix("0x")
        }

        val offsetMask = Long.parseLong(offset, 16).toInt()

        if (offsetMask >= MAX_OFFSET){
            throw InvalidInstructionException("Offset must be less than $MAX_OFFSET")
        }
        instruction.encoded = instruction.encoded.or(offsetMask)


        return Finished();
    }

}
