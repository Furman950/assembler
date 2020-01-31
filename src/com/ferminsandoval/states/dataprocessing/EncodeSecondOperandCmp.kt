package com.ferminsandoval.states.dataprocessing

import com.ferminsandoval.Assembler
import com.ferminsandoval.states.Finished
import com.ferminsandoval.states.State
import com.ferminsandoval.util.getRegisterNumber

class EncodeSecondOperandCmp : State {
    override fun nextState(assembler: Assembler): State {
        val operand2Register = assembler.currentStatement.parameters[1]
        var registerNumber = getRegisterNumber(operand2Register)

        assembler.binaryInstruction = assembler.binaryInstruction.or(registerNumber)

        return Finished()
    }
}