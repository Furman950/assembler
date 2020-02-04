package com.ferminsandoval.states.dataprocessing.mov

import com.ferminsandoval.models.Instruction
import com.ferminsandoval.models.instructionSet
import com.ferminsandoval.states.State

class Mov : State {
    override fun nextState(instruction: Instruction): State {
        val bitMask = instructionSet[instruction.label]!!
        instruction.encoded = instruction.encoded.or(bitMask)

        return EncodeDestinationRegister()
    }

}
