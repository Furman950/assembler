package com.ferminsandoval.states.dataprocessing.mov

import com.ferminsandoval.models.Instruction
import com.ferminsandoval.states.State
import com.ferminsandoval.util.getRegisterNumber

class EncodeDestinationRegister : State {
    override fun nextState(instruction: Instruction): State {
        val index = 0
        val register = instruction.parameters[index]
        val registerNumber = getRegisterNumber(register)
            .shl(12)

        instruction.encoded = instruction.encoded.or(registerNumber)

        return EncodeSourceRegister()
    }

}
