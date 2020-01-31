package com.ferminsandoval.states.dataprocessing

import com.ferminsandoval.Assembler
import com.ferminsandoval.exceptions.InvalidStatementException
import com.ferminsandoval.states.Finished
import com.ferminsandoval.states.State

class EncodeSecondOperand : State {
    override fun nextState(assembler: Assembler): State {
        if (assembler.currentStatement.parameters.size == 2)
            return Finished()

        var operand2 = assembler.currentStatement.parameters[2]

        var binaryMask = 0

        binaryMask = when {
            operand2.startsWith("0x") -> {
                getHexValue(operand2)
            }
            operand2.startsWith("R") -> {
                getRegisterValue(operand2)
            }
            else -> {
                throw InvalidStatementException("Invalid statement at line ${assembler.currentLine}")
            }
        }

        assembler.binaryInstruction = assembler.binaryInstruction.or(binaryMask)

        return Finished()
    }

    private fun getRegisterValue(operand2: String): Int = getRegisterValue(operand2)

    private fun getHexValue(operand2: String): Int {
        val switchBitToImmediateValue = 0x2000000
        return Integer.parseInt(operand2.removePrefix("0x"), 16)
            .or(switchBitToImmediateValue)
    }
}
