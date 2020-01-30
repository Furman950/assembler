package com.ferminsandoval.states.move

import com.ferminsandoval.Assembler
import com.ferminsandoval.states.State
import com.ferminsandoval.util.getRegisterNumber

class EncodeDestinationRegister : State {
    override fun nextState(assembler: Assembler): State {
        val register = assembler.currentInstruction.parameters[0]
        val number = getRegisterNumber(register).shl(12)
        assembler.binaryInstruction = assembler.binaryInstruction.or(number)

        return EncodeImmediateValue()
    }
}
