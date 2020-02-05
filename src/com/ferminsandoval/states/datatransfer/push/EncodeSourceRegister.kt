package com.ferminsandoval.states.datatransfer.push

import com.ferminsandoval.models.Instruction
import com.ferminsandoval.states.Finished
import com.ferminsandoval.states.State
import com.ferminsandoval.util.getRegisterNumber

class EncodeSourceRegister : State {
    override fun nextState(instruction: Instruction): State {
        val sourceRegister = instruction.parameters[0]
        val registerNumber = getRegisterNumber(sourceRegister)
        val registserMask = registerNumber.shl(12)

        instruction.encoded = instruction.encoded.or(registserMask)

        return Finished()
    }

}
