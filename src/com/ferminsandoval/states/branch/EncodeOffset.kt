package com.ferminsandoval.states.branch

import com.ferminsandoval.Assembler
import com.ferminsandoval.states.Finished
import com.ferminsandoval.states.State

class EncodeOffset : State {
    override fun nextState(assembler: Assembler): State {
        var offset = assembler.currentStatement.parameters[0]
        if (offset.startsWith("0x")){
           offset = offset.removePrefix("0x")
        }

        val offsetMask = Integer.parseInt(offset, 16)

        assembler.binaryInstruction = assembler.binaryInstruction.or(offsetMask)

        return Finished()
    }

}
