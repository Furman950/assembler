package com.ferminsandoval.states.datatransfer

import com.ferminsandoval.Assembler
import com.ferminsandoval.exceptions.InvalidStatementException
import com.ferminsandoval.models.dataTransfer
import com.ferminsandoval.states.State

class DataTransferInstruction : State {
    override fun nextState(assembler: Assembler): State {
        if (assembler.currentStatement.parameters.size < 2){
            throw InvalidStatementException("Invalid statement at line ${assembler.currentLine}")
        }

        val labelMask = dataTransfer[assembler.currentStatement.label]
        assembler.binaryInstruction = assembler.binaryInstruction.or(labelMask!!)

        return EncodeBaseRegister()
    }
}