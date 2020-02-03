package com.ferminsandoval.states.datatransfer.str

import com.ferminsandoval.models.Instruction
import com.ferminsandoval.states.Finished
import com.ferminsandoval.states.State
import com.ferminsandoval.util.getRegisterNumber

class EncodeDestinationRegister : State {
    override fun nextState(instruction: Instruction): State {
        val destinationRegister = instruction.parameters[0]
        val registerNumber = getRegisterNumber(destinationRegister)
        val registerMask = registerNumber.shl(12)

        instruction.encoded = instruction.encoded.or(registerMask)

        return Finished()
    }

}
