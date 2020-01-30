package com.ferminsandoval.states.dataprocessing

import com.ferminsandoval.Assembler
import com.ferminsandoval.exceptions.InvalidRegisterException
import com.ferminsandoval.states.State

class DataProcessingInstruction : State {
    override fun nextState(assembler: Assembler): State {
        if (!assembler.currentInstruction.parameters[0].startsWith("R") &&
                !assembler.currentInstruction.parameters[1].startsWith("R")) {
            throw InvalidRegisterException("Missing 1st operand register or Destination register on line ${assembler.currentLine}")
        }
        return this
    }
}