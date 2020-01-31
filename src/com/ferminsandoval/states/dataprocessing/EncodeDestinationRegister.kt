package com.ferminsandoval.states.dataprocessing

import com.ferminsandoval.Assembler
import com.ferminsandoval.states.State
import com.ferminsandoval.util.getRegisterNumber

class EncodeDestinationRegister : State {
    override fun nextState(assembler: Assembler): State {
        val destinationRegister = assembler.currentStatement.parameters[0]
        val registerNumber = getRegisterNumber(destinationRegister)
            .shl(12)

        assembler.binaryInstruction = assembler.binaryInstruction.or(registerNumber)

        return EncodeSecondOperand()
    }
}