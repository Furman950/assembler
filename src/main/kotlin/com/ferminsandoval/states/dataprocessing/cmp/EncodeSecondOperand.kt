package main.kotlin.com.ferminsandoval.states.dataprocessing.cmp

import main.kotlin.com.ferminsandoval.models.Instruction
import main.kotlin.com.ferminsandoval.states.Finished
import main.kotlin.com.ferminsandoval.states.State
import main.kotlin.com.ferminsandoval.util.getRegisterNumber

class EncodeSecondOperand : State {
    override fun nextState(instruction: Instruction): State {
        val operand2Register = instruction.parameters[1]
        val registerNumber = getRegisterNumber(operand2Register)

        instruction.encoded = instruction.encoded.or(registerNumber)

        return Finished()
    }

}
