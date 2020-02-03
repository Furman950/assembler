package com.ferminsandoval.states.dataprocessing.or

import com.ferminsandoval.exceptions.InvalidInstructionException
import com.ferminsandoval.models.Instruction
import com.ferminsandoval.states.Finished
import com.ferminsandoval.states.State
import com.ferminsandoval.util.getRegisterNumber

class EncodeSecondOperand : State {
    override fun nextState(instruction: Instruction): State {
        if (instruction.parameters.size == 2) return Finished()

        var operand2 = instruction.parameters[2]
        var bitMask = when {
            operand2.startsWith("0x") -> {
                getHexValue(operand2)
            }
            operand2.startsWith("R") -> {
                getRegisterNumber(operand2)
            }
            else -> {
                throw InvalidInstructionException("Invalid statement at line ${instruction.positionInFile}")
            }
        }

        instruction.encoded = instruction.encoded.or(bitMask)

        return Finished()
    }

    private fun getHexValue(operand2: String): Int {
        val switchBitToImmediateValue = 0x2000000
        return Integer.parseInt(operand2.removePrefix("0x"), 16)
            .or(switchBitToImmediateValue)
    }

}
