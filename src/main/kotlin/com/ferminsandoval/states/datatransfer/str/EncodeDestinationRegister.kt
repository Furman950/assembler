package main.kotlin.com.ferminsandoval.states.datatransfer.str

import main.kotlin.com.ferminsandoval.models.Instruction
import main.kotlin.com.ferminsandoval.states.Finished
import main.kotlin.com.ferminsandoval.states.State
import main.kotlin.com.ferminsandoval.util.getRegisterNumber

class EncodeDestinationRegister : State {
    override fun nextState(instruction: Instruction): State {
        val destinationRegister = instruction.parameters[0]
        val registerNumber = getRegisterNumber(destinationRegister)
        val registerMask = registerNumber.shl(12)

        instruction.encoded = instruction.encoded.or(registerMask)

        return if (instruction.parameters.size == 2) Finished()
        else EncodeOffset()
    }

}
