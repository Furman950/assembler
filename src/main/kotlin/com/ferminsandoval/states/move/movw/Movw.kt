package main.kotlin.com.ferminsandoval.states.move.movw

import main.kotlin.com.ferminsandoval.models.Instruction
import main.kotlin.com.ferminsandoval.models.instructionSet
import main.kotlin.com.ferminsandoval.states.State
import main.kotlin.com.ferminsandoval.states.move.EncodeDestinationRegister

class Movw : State {

    override fun nextState(instruction: Instruction): State {
        val bitMask = instructionSet[instruction.label]!!
        instruction.encoded = instruction.encoded.or(bitMask)
        return EncodeDestinationRegister()
    }
}
