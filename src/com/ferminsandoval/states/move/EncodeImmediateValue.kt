package com.ferminsandoval.states.move

import com.ferminsandoval.exceptions.InvalidRangeException
import com.ferminsandoval.models.Instruction
import com.ferminsandoval.states.Finished
import com.ferminsandoval.states.State

import java.lang.Long

class EncodeImmediateValue : State {
    override fun nextState(instruction: Instruction): State {
        val immediateValueStr = instruction.parameters[1]
        val immediateValue = getImmediateValue(immediateValueStr)

        val imm4 = immediateValue.ushr(12)
            .shl(16)
        val imm12 = immediateValue.and(0xFFF)

        instruction.encoded = instruction.encoded.or(imm4)
            .or(imm12)

        return Finished()
    }

    private fun getImmediateValue(rawImmediateValue: String): Int {

        var immediateValue = if (rawImmediateValue.startsWith("0x")) {
            Long.parseLong(rawImmediateValue.removePrefix("0x"), 16).toInt()
        } else {
            rawImmediateValue.toInt()
        }

        if (immediateValue > 0xFFFF) {
            throw InvalidRangeException("Immediate value must be between 0x0 and 0xFFFF, but got $rawImmediateValue")
        }

        return immediateValue
    }
}