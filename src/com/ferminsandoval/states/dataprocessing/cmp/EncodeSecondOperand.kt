package com.ferminsandoval.states.dataprocessing.cmp

import com.ferminsandoval.models.Instruction
import com.ferminsandoval.states.Finished
import com.ferminsandoval.states.State
import com.ferminsandoval.util.getRegisterNumber

class EncodeSecondOperand : State {
    override fun nextState(instruction: Instruction): State {
        val operand2Register = instruction.parameters[1]
        val registerNumber = getRegisterNumber(operand2Register)

        instruction.encoded = instruction.encoded.or(registerNumber)

        return Finished()
    }

}
