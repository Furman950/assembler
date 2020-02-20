package main.kotlin.com.ferminsandoval.states.datatransfer.push

import main.kotlin.com.ferminsandoval.models.Instruction
import main.kotlin.com.ferminsandoval.states.Finished
import main.kotlin.com.ferminsandoval.states.State
import main.kotlin.com.ferminsandoval.util.getRegisterNumber

class EncodeSourceRegister : State {
    override fun nextState(instruction: Instruction): State {
        val sourceRegister = instruction.parameters[0]
        val registerNumber = getRegisterNumber(sourceRegister)
        val registserMask = registerNumber.shl(12)

        instruction.encoded = instruction.encoded.or(registserMask)

        return Finished()
    }

}
