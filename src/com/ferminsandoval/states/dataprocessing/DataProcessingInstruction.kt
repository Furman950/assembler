package com.ferminsandoval.states.dataprocessing

import com.ferminsandoval.Assembler
import com.ferminsandoval.exceptions.InvalidStatementException
import com.ferminsandoval.models.dataProcessing
import com.ferminsandoval.states.State

class DataProcessingInstruction : State {
    override fun nextState(assembler: Assembler): State {
//        if (assembler.currentStatement.parameters.size < 3){
//            throw InvalidStatementException("Invalid statement at line ${assembler.currentLine}")
//        }

//        if (!assembler.currentStatement.parameters[0].startsWith("R") &&
//                !assembler.currentStatement.parameters[1].startsWith("R")) {
//            throw InvalidRegisterException("Missing 1st operand register or Destination register on line ${assembler.currentLine}")
//        }

        val label = dataProcessing[assembler.currentStatement.label]
        assembler.binaryInstruction = assembler.binaryInstruction.or(label!!)

        return EncodeFirstOperandRegister()
    }
}