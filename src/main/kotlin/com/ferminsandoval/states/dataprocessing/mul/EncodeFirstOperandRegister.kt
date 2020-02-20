package main.kotlin.com.ferminsandoval.states.dataprocessing.mul

import main.kotlin.com.ferminsandoval.models.Instruction
import main.kotlin.com.ferminsandoval.states.State
import main.kotlin.com.ferminsandoval.util.getRegisterNumber

class EncodeFirstOperandRegister : State {
    override fun nextState(instruction: Instruction): State {
        val firstRegister = instruction.parameters[1];
        val registerNumber = getRegisterNumber(firstRegister);

        instruction.encoded = instruction.encoded.or(registerNumber);

        return EncodeSecondOperandRegister();
    }
}