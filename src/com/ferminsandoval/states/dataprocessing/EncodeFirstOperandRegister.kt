package com.ferminsandoval.states.dataprocessing

import com.ferminsandoval.Assembler
import com.ferminsandoval.states.State
import com.ferminsandoval.util.getRegisterNumber

class EncodeFirstOperandRegister : State {
    override fun nextState(assembler: Assembler): State {
        val index = if (assembler.currentStatement.label == "CMP") 0 else 1
        val firstOperandRegister = assembler.currentStatement.parameters[index]
        val registerNumber = getRegisterNumber(firstOperandRegister)
            .shl(16)
        assembler.binaryInstruction = assembler.binaryInstruction.or(registerNumber)


        return EncodeDestinationRegister()
    }

}
