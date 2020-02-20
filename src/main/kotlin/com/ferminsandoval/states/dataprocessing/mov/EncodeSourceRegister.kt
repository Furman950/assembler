package main.kotlin.com.ferminsandoval.states.dataprocessing.mov

import main.kotlin.com.ferminsandoval.models.Instruction
import main.kotlin.com.ferminsandoval.states.Finished
import main.kotlin.com.ferminsandoval.states.State
import main.kotlin.com.ferminsandoval.util.getRegisterNumber

class EncodeSourceRegister : State {
    override fun nextState(instruction: Instruction): State {
        val index = 1
        val register = instruction.parameters[index]
        val registerNumber = getRegisterNumber(register)

        instruction.encoded = instruction.encoded.or(registerNumber)

        return Finished()
    }

}
