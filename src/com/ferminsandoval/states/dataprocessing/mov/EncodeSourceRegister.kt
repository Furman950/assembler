package com.ferminsandoval.states.dataprocessing.mov

import com.ferminsandoval.models.Instruction
import com.ferminsandoval.states.Finished
import com.ferminsandoval.states.State
import com.ferminsandoval.util.getRegisterNumber

class EncodeSourceRegister : State {
    override fun nextState(instruction: Instruction): State {
        val index = 1
        val register = instruction.parameters[index]
        val registerNumber = getRegisterNumber(register)

        instruction.encoded = instruction.encoded.or(registerNumber)

        return Finished()
    }

}
