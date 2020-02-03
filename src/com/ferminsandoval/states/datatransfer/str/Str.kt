package com.ferminsandoval.states.datatransfer.str

import com.ferminsandoval.models.Instruction
import com.ferminsandoval.models.instructionSet
import com.ferminsandoval.states.State

class Str : State {
    override fun nextState(instruction: Instruction): State {
        val bitMask = instructionSet[instruction.label]!!

        instruction.encoded = instruction.encoded.or(bitMask)

        return EncodeBaseRegister()
    }

}
