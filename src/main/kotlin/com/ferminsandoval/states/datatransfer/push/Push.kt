package main.kotlin.com.ferminsandoval.states.datatransfer.push

import main.kotlin.com.ferminsandoval.models.Instruction
import main.kotlin.com.ferminsandoval.models.instructionSet
import main.kotlin.com.ferminsandoval.states.State

class Push : State {
    override fun nextState(instruction: Instruction): State {
        val bitMask = instructionSet[instruction.label]!!
        instruction.encoded = instruction.encoded.or(bitMask)

        return EncodeSourceRegister()
    }

}
