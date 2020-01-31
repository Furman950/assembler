package com.ferminsandoval.states.move

import com.ferminsandoval.Assembler
import com.ferminsandoval.exceptions.InvalidRangeException
import com.ferminsandoval.states.Finished
import com.ferminsandoval.states.State

class EncodeImmediateValue : State {
    override fun nextState(assembler: Assembler): State {
        var immediateStringValue = assembler.currentStatement.parameters[1]

        val immediateValue = getImmediateValue(immediateStringValue)

        val imm4 = immediateValue.ushr(12)
            .shl(16)
        val imm12 = immediateValue.and(0xFFF)

        assembler.binaryInstruction = assembler.binaryInstruction.or(imm4)
            .or(imm12)

        return Finished()
    }

    private fun getImmediateValue(rawImmediateValue: String): Int {

        var immediateValue = if (rawImmediateValue.startsWith("0x")) {
            Integer.parseInt(rawImmediateValue.removePrefix("0x"), 16)
        } else {
            rawImmediateValue.toInt()
        }

        if (immediateValue > 0xFFFF) {
            throw InvalidRangeException("Immediate value must be between 0x0 and 0xFFFF, but got $rawImmediateValue")
        }

        return immediateValue
    }

}
