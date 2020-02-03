package com.ferminsandoval.states.dataprocessing.add

import com.ferminsandoval.models.Instruction
import com.ferminsandoval.states.State
import com.ferminsandoval.util.getRegisterNumber

class EncodeFirstOperandRegister : State {
    override fun nextState(instruction: Instruction): State {
        val index = 1
        val register = instruction.parameters[index]
        val registerNumber = getRegisterNumber(register)
            .shl(16)

        instruction.encoded = instruction.encoded.or(registerNumber)

        return EncodeDestinationRegister()
    }
}