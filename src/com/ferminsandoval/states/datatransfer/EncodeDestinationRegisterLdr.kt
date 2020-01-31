package com.ferminsandoval.states.datatransfer

import com.ferminsandoval.Assembler
import com.ferminsandoval.states.Finished
import com.ferminsandoval.states.State
import com.ferminsandoval.util.getRegisterNumber

class EncodeDestinationRegisterLdr : State {
    override fun nextState(assembler: Assembler): State {
        val destinationRegister = assembler.currentStatement.parameters[0]
        val registerNumber = getRegisterNumber(destinationRegister)
        val registerMask = registerNumber.shl(12)

        assembler.binaryInstruction = assembler.binaryInstruction.or(registerMask)

        return Finished()
    }
}
