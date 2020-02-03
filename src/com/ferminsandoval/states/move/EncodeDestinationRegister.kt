package com.ferminsandoval.states.move

import com.ferminsandoval.models.Instruction
import com.ferminsandoval.states.State
import com.ferminsandoval.util.getRegisterNumber

class EncodeDestinationRegister : State{
    override fun nextState(instruction: Instruction): State {
        val register = instruction.parameters[0]
        val registerNumber = getRegisterNumber(register).shl(12)

        instruction.encoded = instruction.encoded.or(registerNumber)

        return EncodeImmediateValue()
    }
}