package com.ferminsandoval.states.datatransfer.str

import com.ferminsandoval.models.Instruction
import com.ferminsandoval.states.State
import com.ferminsandoval.util.getRegisterNumber

class EncodeBaseRegister : State {
    override fun nextState(instruction: Instruction): State {
        val baseRegister = instruction.parameters[1]
            .replace(Regex("[()]"), "")
        val registerNumber = getRegisterNumber(baseRegister)
        val registerMask = registerNumber.shl(16)

        instruction.encoded = instruction.encoded.or(registerMask)

        return EncodeDestinationRegister()
    }

}
