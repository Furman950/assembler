package com.ferminsandoval.states.datatransfer

import com.ferminsandoval.Assembler
import com.ferminsandoval.states.State
import com.ferminsandoval.util.getRegisterNumber

class EncodeBaseRegister : State {
    override fun nextState(assembler: Assembler): State {
        val baseRegister = assembler.currentStatement.parameters[1].replace(Regex("[()]"), "")
        val registerNumber = getRegisterNumber(baseRegister)
        val registerMask = registerNumber.shl(16)

        assembler.binaryInstruction = assembler.binaryInstruction.or(registerMask)

        return EncodeDestinationRegister()
    }
}
