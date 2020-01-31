package com.ferminsandoval.states.move

import com.ferminsandoval.Assembler
import com.ferminsandoval.models.moveInstructions
import com.ferminsandoval.states.State

class MoveInstruction : State {
    override fun nextState(assembler: Assembler): State {
        val mov = moveInstructions[assembler.currentStatement.label]
        assembler.binaryInstruction = assembler.binaryInstruction.or(mov!!)

        return EncodeDestinationRegister()
    }
}