package com.ferminsandoval.states.branch

import com.ferminsandoval.Assembler
import com.ferminsandoval.models.branching
import com.ferminsandoval.states.State

class BranchingInstruction : State {
    override fun nextState(assembler: Assembler): State {
        val label = branching[assembler.currentStatement.label]
        assembler.binaryInstruction = assembler.binaryInstruction.or(label!!)

        return EncodeOffset();
    }
}