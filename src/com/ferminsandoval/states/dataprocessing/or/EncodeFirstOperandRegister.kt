package com.ferminsandoval.states.dataprocessing.or

import com.ferminsandoval.models.Instruction
import com.ferminsandoval.states.State
import com.ferminsandoval.util.getRegisterNumber

class EncodeFirstOperandRegister : State {
    override fun nextState(instruction: Instruction): State {
        val index = 1
        val regiser = instruction.parameters[index]
        val registerNumber = getRegisterNumber(regiser)
            .shl(16)

        instruction.encoded = instruction.encoded.or(registerNumber)

        return EncodeDestinationRegister()
    }
}