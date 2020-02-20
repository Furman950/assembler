package main.kotlin.com.ferminsandoval.states.dataprocessing.mul

import main.kotlin.com.ferminsandoval.models.Instruction
import main.kotlin.com.ferminsandoval.states.State
import main.kotlin.com.ferminsandoval.util.getRegisterNumber

class EncodeDestinationRegister : State {
    override fun nextState(instruction: Instruction): State {
        val destinationRegister = instruction.parameters[0];
        val registerNumber = getRegisterNumber(destinationRegister)
            .shl(16);

        instruction.encoded = instruction.encoded.or(registerNumber);

        return EncodeFirstOperandRegister()
    }
}