package com.ferminsandoval.states.datatransfer

import com.ferminsandoval.Assembler
import com.ferminsandoval.states.State
import com.ferminsandoval.util.getRegisterNumber

class EncodeBaseRegisterStr : State {
    override fun nextState(assembler: Assembler): State {
        val baseRegister = assembler.currentStatement.parameters[0]
        val registerNumber = getRegisterNumber(baseRegister)

        return this
    }

}
