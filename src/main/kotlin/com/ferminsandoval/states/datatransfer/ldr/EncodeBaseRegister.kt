package main.kotlin.com.ferminsandoval.states.datatransfer.ldr

import main.kotlin.com.ferminsandoval.models.Instruction
import main.kotlin.com.ferminsandoval.states.State
import main.kotlin.com.ferminsandoval.util.getRegisterNumber

class EncodeBaseRegister : State {
    override fun nextState(instruction: Instruction): State {
        val baseRegister = instruction.parameters[1]
            .replace(Regex("[()]"), "")
        val registerNumber = getRegisterNumber(baseRegister)
        val registerMask = registerNumber.shl(16)

        instruction.encoded = instruction.encoded.or(registerMask)

        return EncodeDestinationRegister()
    }

}
