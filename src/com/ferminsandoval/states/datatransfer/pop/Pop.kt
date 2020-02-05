package com.ferminsandoval.states.datatransfer.pop

import com.ferminsandoval.models.Instruction
import com.ferminsandoval.models.instructionSet
import com.ferminsandoval.states.State

class Pop : State {
    override fun nextState(instruction: Instruction): State {
        val bitMask = instructionSet[instruction.label]!!
        instruction.encoded = instruction.encoded.or(bitMask)

        return EncodeDestinationRegister()
    }

}
