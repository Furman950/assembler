package main.kotlin.com.ferminsandoval.states.dataprocessing.add

import main.kotlin.com.ferminsandoval.models.Instruction
import main.kotlin.com.ferminsandoval.states.State
import main.kotlin.com.ferminsandoval.util.getRegisterNumber

class EncodeDestinationRegister : State {
    override fun nextState(instruction: Instruction): State {
        val destinationRegister = instruction.parameters[0]
        val registerNumber = getRegisterNumber(destinationRegister)
            .shl(12)

        instruction.encoded = instruction.encoded.or(registerNumber)

        return EncodeSecondOperand()
    }
}