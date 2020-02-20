package main.kotlin.com.ferminsandoval.states.dataprocessing.mul

import main.kotlin.com.ferminsandoval.models.Instruction
import main.kotlin.com.ferminsandoval.states.Finished
import main.kotlin.com.ferminsandoval.states.State
import main.kotlin.com.ferminsandoval.util.getRegisterNumber

class EncodeSecondOperandRegister : State {
    override fun nextState(instruction: Instruction): State {
        val secondOperandRegister = instruction.parameters[2];
        val registerNumber = getRegisterNumber(secondOperandRegister)
            .shl(8)
        instruction.encoded = instruction.encoded.or(registerNumber)

        return Finished()
    }
}