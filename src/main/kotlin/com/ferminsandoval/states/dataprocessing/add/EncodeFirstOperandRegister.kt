package main.kotlin.com.ferminsandoval.states.dataprocessing.add

import main.kotlin.com.ferminsandoval.models.Instruction
import main.kotlin.com.ferminsandoval.states.State
import main.kotlin.com.ferminsandoval.util.getRegisterNumber

class EncodeFirstOperandRegister : State {
    override fun nextState(instruction: Instruction): State {
        val index = 1
        val register = instruction.parameters[index]
        val registerNumber = getRegisterNumber(register)
            .shl(16)

        instruction.encoded = instruction.encoded.or(registerNumber)

        return EncodeDestinationRegister()
    }
}