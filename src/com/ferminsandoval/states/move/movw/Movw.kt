package com.ferminsandoval.states.move.movw

import com.ferminsandoval.models.Instruction
import com.ferminsandoval.models.instructionSet
import com.ferminsandoval.states.State
import com.ferminsandoval.states.move.EncodeDestinationRegister

class Movw : State {

    override fun nextState(instruction: Instruction): State {
        val bitMask = instructionSet[instruction.label]!!
        instruction.encoded = instruction.encoded.or(bitMask)
        return EncodeDestinationRegister()
    }
}
